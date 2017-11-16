/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Professor;
import model.dao.impl.ProfessorDao;
import util.CriaHash;

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

     public String logoff() {
         professorLogado = null;
         HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true);
         sessao.invalidate();
         return "/index?faces-redirect=true";
     }
    
    public String logar() {

        String hash = new CriaHash(senha).getHash();
        //System.out.println("==> "+hash);
        professorLogado = new ProfessorDao().findLoginAndPassword(email, hash);
        FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().put("professorLogado", professorLogado);
        if (professorLogado != null) {
            return "security/home?faces-redirect=true";
        } else {
            mensagem = "Email ou Senha Incorreta!!!";
            return "";
        }
    }

    public Professor getProfessorLogado() {
        return professorLogado;
    }

    public void setProfessorLogado(Professor professorLogado) {
        this.professorLogado = professorLogado;
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

}
