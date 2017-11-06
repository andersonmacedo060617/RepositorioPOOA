/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Disciplina;
import model.Professor;
import model.Turma;
import model.dao.impl.DisciplinaDAO;
import model.dao.impl.ProfessorDAO;
import model.dao.impl.TurmaDAO;
import model.status.StatusCrud;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "turma")
@ViewScoped
public class TurmaBean {

    private StatusCrud status;
    private List<Turma> turmas;
    private int ano, semestre, idProfessor, idDisciplina;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    
    

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public StatusCrud getStatus() {
        return status;
    }

    public void setStatus(StatusCrud status) {
        this.status = status;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    
    
    
    
    
    
    /**
     * Creates a new instance of TurmaBean
     */
    public TurmaBean() {
        this.turmas = new TurmaDAO().findAll();
        this.professores = new ProfessorDAO().findAll();
        this.disciplinas = new DisciplinaDAO().findAll();
        status = StatusCrud.all;
        this.idDisciplina = this.idProfessor = -1;
    }
    
    public String matricularAluno(){
        return "security/matricula?faces-redirect=true";
    }
    
    public String criarTurma(){
        return "turma?faces-redirect=true";
    }
    
    public void pesquisa(){
        if(status == StatusCrud.search){
            status = StatusCrud.all;
        }else{
            status = StatusCrud.search;
        }
        
    }
    
    
    
}
