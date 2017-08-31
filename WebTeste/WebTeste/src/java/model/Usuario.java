/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Usuario {
    private String nome, login, senha;
    private boolean ehAdministrador;
    private Date senhaExpirada;

    public Usuario() {
        
    }

    public Usuario(String nome, String login, String senha, boolean ehAdministrador, Date senhaExpirada) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ehAdministrador = ehAdministrador;
        this.senhaExpirada = senhaExpirada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEhAdministrador() {
        return ehAdministrador;
    }

    public void setEhAdministrador(boolean ehAdministrador) {
        this.ehAdministrador = ehAdministrador;
    }

    public Date getSenhaExpirada() {
        return senhaExpirada;
    }

    public void setSenhaExpirada(Date senhaExpirada) {
        this.senhaExpirada = senhaExpirada;
    }
    
    
}
