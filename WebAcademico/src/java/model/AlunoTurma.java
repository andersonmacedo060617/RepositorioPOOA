/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "aluno_turma", catalog = "webacademico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoTurma.findAll", query = "SELECT a FROM AlunoTurma a")
    , @NamedQuery(name = "AlunoTurma.findByTurma", query = "SELECT a FROM AlunoTurma a WHERE a.alunoTurmaPK.turma = :turma")
    , @NamedQuery(name = "AlunoTurma.findByAluno", query = "SELECT a FROM AlunoTurma a WHERE a.alunoTurmaPK.aluno = :aluno")
    , @NamedQuery(name = "AlunoTurma.findByNota1", query = "SELECT a FROM AlunoTurma a WHERE a.nota1 = :nota1")
    , @NamedQuery(name = "AlunoTurma.findByNota2", query = "SELECT a FROM AlunoTurma a WHERE a.nota2 = :nota2")
    , @NamedQuery(name = "AlunoTurma.findByFrequencia", query = "SELECT a FROM AlunoTurma a WHERE a.frequencia = :frequencia")})
public class AlunoTurma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoTurmaPK alunoTurmaPK;
    @Basic(optional = false)
    @Column(nullable = false)
    private double nota1;
    @Basic(optional = false)
    @Column(nullable = false)
    private double nota2;
    @Basic(optional = false)
    @Column(nullable = false)
    private int frequencia;
    @JoinColumn(name = "aluno", referencedColumnName = "idaluno", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno1;
    @JoinColumn(name = "turma", referencedColumnName = "idturma", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma1;

    public AlunoTurma() {
    }

    public AlunoTurma(AlunoTurmaPK alunoTurmaPK) {
        this.alunoTurmaPK = alunoTurmaPK;
    }

    public AlunoTurma(AlunoTurmaPK alunoTurmaPK, double nota1, double nota2, int frequencia) {
        this.alunoTurmaPK = alunoTurmaPK;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.frequencia = frequencia;
    }

    public AlunoTurma(int turma, int aluno) {
        this.alunoTurmaPK = new AlunoTurmaPK(turma, aluno);
    }

    public AlunoTurmaPK getAlunoTurmaPK() {
        return alunoTurmaPK;
    }

    public void setAlunoTurmaPK(AlunoTurmaPK alunoTurmaPK) {
        this.alunoTurmaPK = alunoTurmaPK;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public Aluno getAluno1() {
        return aluno1;
    }

    public void setAluno1(Aluno aluno1) {
        this.aluno1 = aluno1;
    }

    public Turma getTurma1() {
        return turma1;
    }

    public void setTurma1(Turma turma1) {
        this.turma1 = turma1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoTurmaPK != null ? alunoTurmaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTurma)) {
            return false;
        }
        AlunoTurma other = (AlunoTurma) object;
        if ((this.alunoTurmaPK == null && other.alunoTurmaPK != null) || (this.alunoTurmaPK != null && !this.alunoTurmaPK.equals(other.alunoTurmaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AlunoTurma[ alunoTurmaPK=" + alunoTurmaPK + " ]";
    }
    
}
