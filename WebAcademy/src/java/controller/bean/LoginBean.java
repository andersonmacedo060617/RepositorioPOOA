/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import Util.CriaHash;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Professor;
import model.dao.impl.ProfessorDAO;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {
    private String email, senha, mensagem;
    private Professor professorLogado;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Professor getProfessorLogado() {
        return professorLogado;
    }

    public void setProfessorLogado(Professor professorLogado) {
        this.professorLogado = professorLogado;
    }
    
    
    
    public String logar(){
        String hash = new CriaHash(senha).getHash();
        System.out.print(hash);
        Professor p = new ProfessorDAO().findLoginAndaPassword(email, hash);
        
        if(p != null){
            return "home";
        }else{
            mensagem = "Email ou Senha incorreta!";
            
            return "";
        }
    }
    
    
}
