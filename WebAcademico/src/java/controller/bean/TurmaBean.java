/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Aluno;
import model.AlunoTurma;
import model.Disciplina;
import model.Professor;
import model.Turma;
import model.dao.impl.AlunoDao;
import model.dao.impl.DisciplinaDao;
import model.dao.impl.ProfessorDao;
import model.dao.impl.TurmaDao;
import model.status.StatusCrud;

/**
 *
 * @author aluno
 */
@ManagedBean(name = "turma")
@ViewScoped
public class TurmaBean {

    private List<Turma> turmas;
    private StatusCrud status, statusBefore;
    private int ano, idProfessor, idDisciplina;
    private int semestre;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;
    private List<String> alunosSelecionados;
    private Turma selecao;
    private Turma turmaApagada;

    /**
     * Creates a new instance of TurmaBean
     */
    public TurmaBean() {
        turmas = new TurmaDao().findAll();
        professores = new ProfessorDao().findAll();
        disciplinas = new DisciplinaDao().findAll();
        alunos = new AlunoDao().findAll();
        status = StatusCrud.all;
        ano = 2017;
        idProfessor = idDisciplina = -1;
    }

    public void pesquisa() {
        if (status == StatusCrud.search) {
            status = StatusCrud.all;
        } else {
            status = StatusCrud.search;

        }
    }

    public void novaTurma() {
        selecao = new Turma();
        selecao.setProfessor(new Professor());
        selecao.setDisciplina(new Disciplina());
        selecao.setAlunoTurmaList(new ArrayList<>());
        alunosSelecionados = new ArrayList<>();

        statusBefore = status;
        status = StatusCrud.create;
    }

    public void gravar() {

        if (status == StatusCrud.create) {
            new TurmaDao().save(selecao);
            for (String as : alunosSelecionados) {
                selecao.getAlunoTurmaList().add(
                        new AlunoTurma(selecao.getIdturma(), Integer.parseInt(as)));
            }
            new TurmaDao().edit(selecao);
        } else if (status == StatusCrud.edit) {
            new TurmaDao().edit(selecao);
            selecao.setAlunoTurmaList(new ArrayList<>());

            for (String as : alunosSelecionados) {
                selecao.getAlunoTurmaList().add(
                        new AlunoTurma(selecao.getIdturma(), Integer.parseInt(as)));
            }

            new TurmaDao().edit(selecao);
        } else if (status == StatusCrud.lance) {
            new TurmaDao().edit(selecao);
        }

        turmas = new TurmaDao().findAll();
        voltar();
    }

    public void realizaPesquisa() {
        turmas = new TurmaDao().findByAnoAndSemestreAndProfessorAndDisciplina(
                ano, semestre, idProfessor, idDisciplina);
    }

    public void apagar(Turma tur) {
        status = StatusCrud.delete;
        turmaApagada = tur;
    }

    public void alterar(Turma tur) {
        statusBefore = status;
        status = StatusCrud.edit;
        selecao = tur;
        alunosSelecionados = new ArrayList<>();
        for (AlunoTurma at : selecao.getAlunoTurmaList()) {
            alunosSelecionados.add(at.getAluno1().getIdaluno() + "");
        }
    }

    public void lancaNotaFrequencia(Turma tur) {
        statusBefore = status;
        status = StatusCrud.lance;
        selecao = tur;
    }

    public void retornaNãoApagar() {
        status = StatusCrud.all;
    }

    public void voltar() {
        status = statusBefore;
    }

    public String matricularAluno() {
        return "matricula?faces-redirect=true";
    }

    public String criarTurma() {
        return "turma?faces-redirect=true";
    }

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

    public Turma getSelecao() {
        return selecao;
    }

    public void setSelecao(Turma selecao) {
        this.selecao = selecao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<String> getAlunosSelecionados() {
        return alunosSelecionados;
    }

    public void setAlunosSelecionados(List<String> alunosSelecionados) {
        this.alunosSelecionados = alunosSelecionados;
    }

    public Turma getTurmaApagada() {
        return turmaApagada;
    }

    public void setTurmaApagada(Turma turmaApagada) {
        this.turmaApagada = turmaApagada;
    }

}
