/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.caixa.cartaowscliente.main;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author c105118
 */

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;

    private String nome;

    private String cpf;
   
    private Set<Cartao> tbCartaoSet;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public Set<Cartao> getTbCartaoSet() {
        return tbCartaoSet;
    }

    public void setTbCartaoSet(Set<Cartao> tbCartaoSet) {
        this.tbCartaoSet = tbCartaoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
    
}
