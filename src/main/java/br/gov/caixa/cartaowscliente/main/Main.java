/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.caixa.cartaowscliente.main;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

 
/**
 *
 * @author c105118
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("**************************************************************************************");
        System.out.println("* Digite o número de um dos seguintes comandos:                                      *");
        System.out.println("*                                                                                    *");
        System.out.println("* 1 - Cadastrar três clientes, onde o primeiro tenha um cartão, o                    *");
        System.out.println("*     segundo cliente tenha dois cartões e o terceiro cliente tenha cinco cartões.   *");
        System.out.println("*                                                                                    *");
        System.out.println("* 2 - Listar todos os clientes e seus respectivos cartões.                           *");
        System.out.println("*                                                                                    *");
        System.out.println("* 3 - Alterar o nome e data de validade de um cartão e executar novamente a segunda  *");
        System.out.println("*	  opção, de forma que evidencie a alteração.                                     *");
        System.out.println("*                                                                                    *");
        System.out.println("* 4 - Excluir um dos clientes com seus respectivos cartões e executar novamente a    *");
        System.out.println("*     opção 2de forma que evidencie a exclusão                                       *");
        System.out.println("*                                                                                    *");        
        System.out.println("* 0 - Sair do programa                                                               *");
        System.out.println("*                                                                                    *");
        System.out.println("**************************************************************************************");
     
        
        Scanner entrada = new Scanner(System.in); 
        
        boolean loop = true;
                
        do{
            System.out.print("\n Qual comando executar? ");
            try{
                int opcao = entrada.nextInt();
        
                switch(opcao){
                    case 1:                        
                        um();
                        System.out.println("\t Operação realizada com sucesso...");
                        break;
                    case 2:
                        dois();
                        System.out.println("\t Operação realizada com sucesso...");
                        break;
                    case 3:
                         tres();
                         System.out.println("\t Operação realizada com sucesso...");
                          break;
                    case 4:
                         quatro();
                         System.out.println("\t Operação realizada com sucesso...");
                          break;
                    case 0:
                          loop = false;
                          System.out.println("Programa finalizado... ");
                          break;
                    default:
                          System.out.println("Opcao invalida... ");
                          break;
                }
            }catch(Exception ex){
                System.out.print("Comando invalido... ");
            }            
        }
        while(loop);      


    }
    
    
    
    public static void um(){
         Repositorio repo = new Repositorio();
         
        Cliente c1 = Util.criarCliente();
        repo.gravar(c1); //grava o cliente
        repo.gravar(Util.criarCartao(c1)); //grava um cartao
        
        Cliente c2 = Util.criarCliente();
        repo.gravar(c2); //grava o cliente
        repo.gravar(Util.criarCartao(c2)); //grava um cartao
        repo.gravar(Util.criarCartao(c2)); //grava um cartao

        
        Cliente c3 = Util.criarCliente();
        repo.gravar(c3); //grava o cliente
        repo.gravar(Util.criarCartao(c3)); //grava um cartao
        repo.gravar(Util.criarCartao(c3)); //grava um cartao
        repo.gravar(Util.criarCartao(c3)); //grava um cartao
        repo.gravar(Util.criarCartao(c3)); //grava um cartao
        repo.gravar(Util.criarCartao(c3)); //grava um cartao
      
    }
    
    public static void dois(){        
        Repositorio repo = new Repositorio();
        
        Collection<Cliente> lc;
        lc = repo.getAllCliente();
        
        for (Iterator<Cliente> iterator = lc.iterator(); iterator.hasNext();) {
            Cliente next = iterator.next();
            System.err.println("\n Cliente: "+next);
            
            Collection<Cartao> cl;
            cl = repo.getCartoesCliente(next.getIdCliente());
            for (Iterator<Cartao> iterator1 = cl.iterator(); iterator1.hasNext();) {
                Cartao next1 = iterator1.next();
                System.out.println("\t Cartao: "+next1);
                
            }            
            
        }
       
        
    }
    
    public static void tres(){
        Repositorio repo = new Repositorio();
        Cartao card = repo.getCartoes().iterator().next();
        System.out.println("Cartao original: "+card);
        
        card.setNome(Util.gerarNome()+""+Util.gerarNome());
        card.setDtValidade(new Date(1999,12,12));

        System.out.println((repo.editar(card))?"Cartao alterado"+card:"Erro...");
    }
    
    public static void quatro(){
        
        Repositorio repo = new Repositorio();
        
        Cliente c = repo.getAllCliente().iterator().next();
        
        repo.excluirCliente(c.getIdCliente());
        
        System.out.println("\n Cliente excluido: "+c);
    }
    
}


