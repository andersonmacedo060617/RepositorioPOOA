/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "turma")
@ViewScoped
public class TurmaBean {

    /**
     * Creates a new instance of TurmaBean
     */
    public TurmaBean() {
        
    }
    
    public String matricularAluno(){
        return "security/matricula?faces-redirect=true";
    }
    
    public String criarTurma(){
        return "security/turma?faces-redirect=true";
    }
    
}
