/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author aluno
 */
@Embeddable
public class AlunoTurmaPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int turma;
    @Basic(optional = false)
    @Column(nullable = false)
    private int aluno;

    public AlunoTurmaPK() {
    }

    public AlunoTurmaPK(int turma, int aluno) {
        this.turma = turma;
        this.aluno = aluno;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getAluno() {
        return aluno;
    }

    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) turma;
        hash += (int) aluno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTurmaPK)) {
            return false;
        }
        AlunoTurmaPK other = (AlunoTurmaPK) object;
        if (this.turma != other.turma) {
            return false;
        }
        if (this.aluno != other.aluno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AlunoTurmaPK[ turma=" + turma + ", aluno=" + aluno + " ]";
    }
    
}
