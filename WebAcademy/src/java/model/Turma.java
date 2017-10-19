/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aluno
 */
@Entity
@Table(catalog = "academico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t")
    , @NamedQuery(name = "Turma.findByIdturma", query = "SELECT t FROM Turma t WHERE t.idturma = :idturma")
    , @NamedQuery(name = "Turma.findByAno", query = "SELECT t FROM Turma t WHERE t.ano = :ano")
    , @NamedQuery(name = "Turma.findBySemestre", query = "SELECT t FROM Turma t WHERE t.semestre = :semestre")
    , @NamedQuery(name = "Turma.findByDescricao", query = "SELECT t FROM Turma t WHERE t.descricao = :descricao")})
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idturma;
    private Integer ano;
    private Short semestre;
    @Column(length = 45)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma1")
    private List<AlunoTurma> alunoTurmaList;
    @JoinColumn(name = "disciplina", referencedColumnName = "iddisciplina")
    @ManyToOne
    private Disciplina disciplina;
    @JoinColumn(name = "professor", referencedColumnName = "idprofessor")
    @ManyToOne
    private Professor professor;

    public Turma() {
    }

    public Turma(Integer idturma) {
        this.idturma = idturma;
    }

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Short getSemestre() {
        return semestre;
    }

    public void setSemestre(Short semestre) {
        this.semestre = semestre;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturma != null ? idturma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.idturma == null && other.idturma != null) || (this.idturma != null && !this.idturma.equals(other.idturma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Turma[ idturma=" + idturma + " ]";
    }
    
}
