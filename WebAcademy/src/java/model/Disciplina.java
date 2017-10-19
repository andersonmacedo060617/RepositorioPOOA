/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findByIddisciplina", query = "SELECT d FROM Disciplina d WHERE d.iddisciplina = :iddisciplina")
    , @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome")
    , @NamedQuery(name = "Disciplina.findByCargaHoraria", query = "SELECT d FROM Disciplina d WHERE d.cargaHoraria = :cargaHoraria")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iddisciplina;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;
    @OneToMany(mappedBy = "disciplina")
    private List<Turma> turmaList;

    public Disciplina() {
    }

    public Disciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Disciplina(Integer iddisciplina, String nome, int cargaHoraria) {
        this.iddisciplina = iddisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddisciplina != null ? iddisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.iddisciplina == null && other.iddisciplina != null) || (this.iddisciplina != null && !this.iddisciplina.equals(other.iddisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Disciplina[ iddisciplina=" + iddisciplina + " ]";
    }
    
}
