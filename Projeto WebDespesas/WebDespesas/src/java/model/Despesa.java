/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(catalog = "despesas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despesa.findAll", query = "SELECT d FROM Despesa d")
    , @NamedQuery(name = "Despesa.findById", query = "SELECT d FROM Despesa d WHERE d.id = :id")
    , @NamedQuery(name = "Despesa.findByDatadespesa", query = "SELECT d FROM Despesa d WHERE d.datadespesa = :datadespesa")
    , @NamedQuery(name = "Despesa.findByDescricao", query = "SELECT d FROM Despesa d WHERE d.descricao = :descricao")
    , @NamedQuery(name = "Despesa.findByPaga", query = "SELECT d FROM Despesa d WHERE d.paga = :paga")
    , @NamedQuery(name = "Despesa.findByValor", query = "SELECT d FROM Despesa d WHERE d.valor = :valor")})
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datadespesa;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String descricao;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean paga;
    @Basic(optional = false)
    @Column(nullable = false)
    private double valor;
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Categoria categoriaId;
    @JoinColumn(name = "Usuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Despesa() {
    }

    public Despesa(Integer id) {
        this.id = id;
    }

    public Despesa(Integer id, Date datadespesa, String descricao, boolean paga, double valor) {
        this.id = id;
        this.datadespesa = datadespesa;
        this.descricao = descricao;
        this.paga = paga;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatadespesa() {
        return datadespesa;
    }

    public void setDatadespesa(Date datadespesa) {
        this.datadespesa = datadespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Despesa[ id=" + id + " ]";
    }
    
}
