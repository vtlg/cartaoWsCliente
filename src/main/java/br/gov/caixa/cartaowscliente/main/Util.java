/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.caixa.cartaowscliente.main;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author c105118
 */
public class Util {
    
    /**
     *
     * @return
     */
    public static String gerarNome(){
        char[] alphNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++)
            sb.append(alphNum[rnd.nextInt(alphNum.length)]);

        String id = sb.toString();

        return id;
        
    }
    
    public static String gerarNumeroCartao(){
        char[] alphNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder((1000 + rnd.nextInt(9000)) + ""+
        (1000 + rnd.nextInt(9000)) + ""+
        (1000 + rnd.nextInt(9000)) + ""+
        (1000 + rnd.nextInt(9000)));
        
        return sb.toString();
    }
    
    public static String gerarCpf(){
         char[] alphNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder((100 + rnd.nextInt(900)) + ""+
        (100 + rnd.nextInt(900)) + ""+
        (100 + rnd.nextInt(900)) + ""+
        (10 + rnd.nextInt(90)));
        
        return sb.toString();
    }
    
    public static Cartao criarCartao(Cliente cliente){
        Cartao c = new Cartao();
        c.setDtValidade(new Date());
        c.setIdCliente(cliente);
        c.setNome(gerarNome());
        c.setNumero(gerarNumeroCartao());
        return c;
    }
    
    public static Cliente criarCliente(){
        Cliente c = new Cliente();
        c.setNome("Cliente "+gerarNome());
        c.setCpf(gerarCpf());
        c.setIdCliente(10+new Random().nextInt(900000));
        return c;
    }
    
}

