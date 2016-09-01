/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.caixa.cartaowscliente.main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author c105118
 */
public class Repositorio {
    
    public void gravar(Cliente c){
        try {
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cliente");
 
            Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(new Gson().toJson(c), "application/json"));      

            if (response.getStatus() != 204) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
             
            response.close();
 
        } catch (Exception e) { 
            e.printStackTrace();
 
        }
 
    }
    
     public void gravar(Cartao c){
        try {
            //Para não entrar em loop infinito
            c.getIdCliente().setTbCartaoSet(null);
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cartao/add");
 
           //Response response = target.request(MediaType.APPLICATION_JSON).get(); 
            Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(new Gson().toJson(c), "application/json"));      

 
            if (response.getStatus() != 204) { 
               // throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
             
            response.close();
 
        } catch (Exception e) { 
            e.printStackTrace();
 
        }
 
    }
    
    public Cliente getCliente(Integer id){
         Gson gson = new Gson();
        Cliente c = new Cliente();
        try {
            
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cliente").path(id.toString());
 
           //Response response = target.request(MediaType.APPLICATION_JSON).get(); 
            Response response = target.request(MediaType.APPLICATION_JSON).get();     

            if (response.getStatus() != 200) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
            
            c = gson.fromJson(response.readEntity(String.class), Cliente.class);
            response.close();
 
        } catch (Exception e) { 
            return null;
        }
        return c ;
    }
    
    public void excluirCliente(Integer id){
         Gson gson = new Gson();
        Cliente c = new Cliente();
        try {
            
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cliente").path(id.toString());
 
           //Response response = target.request(MediaType.APPLICATION_JSON).get(); 
            Response response = target.request(MediaType.APPLICATION_JSON).delete();     

            if (response.getStatus() != 204) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
            
            c = gson.fromJson(response.readEntity(String.class), Cliente.class);
            response.close();
 
        } catch (Exception e) { 
            e.printStackTrace();
        }

    }
    
    public Collection<Cliente> getAllCliente(){
         Gson gson = new Gson();
        Collection<Cliente> result;
        try {
            
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cliente");
 
           //Response response = target.request(MediaType.APPLICATION_JSON).get(); 
            Response response = target.request(MediaType.APPLICATION_JSON).get();     

            if (response.getStatus() != 200) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
      
            Type ty = new TypeToken<Collection<Cliente>>(){}.getType();
            result =  gson.fromJson(response.readEntity(String.class),ty );
            response.close();
 
        } catch (Exception e) { 
            e.printStackTrace();
            return null;
        }
        return result ;
    }
    
    public Collection<Cartao> getCartoesCliente(Integer id){
         Gson gson = new Gson();
        Collection<Cartao> result;
        try {
            
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cartao/cliente").path(id.toString());
 
            Response response = target.request(MediaType.APPLICATION_JSON).get();     

            if (response.getStatus() != 200) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
      
            Type ty = new TypeToken<Collection<Cartao>>(){}.getType();
            result =  gson.fromJson(response.readEntity(String.class),ty );
            response.close();
 
        } catch (Exception e) { 
            e.printStackTrace();
            return null;
        }
        return result ;
    }
    
    public Collection<Cartao> getCartoes(){
         Gson gson = new Gson();
        Collection<Cartao> result;
        try {
            
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cartao/all");
  
            Response response = target.request(MediaType.APPLICATION_JSON).get();     

            if (response.getStatus() != 200) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
      
            Type ty = new TypeToken<Collection<Cartao>>(){}.getType();
            result =  gson.fromJson(response.readEntity(String.class),ty );
            response.close();
 
        } catch (Exception e) { 
            e.printStackTrace();
            return null;
        }
        return result ;
    }
    
    public boolean editar(Cartao c){
        try {
            Gson gson = new Gson();
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cartao").path(c.getNumero());
 
           //Response response = target.request(MediaType.APPLICATION_JSON).get(); 
            Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.entity(gson.toJson(c), "application/json"));      

            if (response.getStatus() != 204) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
             
            response.close();
 
        } catch (Exception e) { 
            return false;
        }
        return true;
    }
    public boolean editar(Cliente c){
        try {
            Gson gson = new Gson();
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cliente").path(c.getIdCliente().toString());
 
           //Response response = target.request(MediaType.APPLICATION_JSON).get(); 
            Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.entity(gson.toJson(c), "application/json"));      

            if (response.getStatus() != 204) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
             
            response.close();
 
        } catch (Exception e) { 
            return false;
        }
        return true;
    }
    
    public Cartao getCartao(String id){
        Gson gson = new Gson();
        Cartao c = new Cartao();
        try {
            
            ResteasyClient client = new ResteasyClientBuilder().build(); 
            
            ResteasyWebTarget target = client.target("http://localhost:8080/cartaows/ws/cartao").path(id);
 
            Response response = target.request(MediaType.APPLICATION_JSON).get();     

            if (response.getStatus() != 200) { 
                throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus()); 
            }
            
            c = gson.fromJson(response.readEntity(String.class), Cartao.class);
            response.close();
 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c ;
    }
    
}
