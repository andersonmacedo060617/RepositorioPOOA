/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByIdaluno", query = "SELECT a FROM Aluno a WHERE a.idaluno = :idaluno")
    , @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome")
    , @NamedQuery(name = "Aluno.findByEmail", query = "SELECT a FROM Aluno a WHERE a.email = :email")
    , @NamedQuery(name = "Aluno.findByNascimento", query = "SELECT a FROM Aluno a WHERE a.nascimento = :nascimento")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idaluno;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(length = 45)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno1")
    private List<AlunoTurma> alunoTurmaList;

    public Aluno() {
    }

    public Aluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Aluno(Integer idaluno, String nome, Date nascimento) {
        this.idaluno = idaluno;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @XmlTransient
    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaluno != null ? idaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idaluno == null && other.idaluno != null) || (this.idaluno != null && !this.idaluno.equals(other.idaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aluno[ idaluno=" + idaluno + " ]";
    }
    
}
