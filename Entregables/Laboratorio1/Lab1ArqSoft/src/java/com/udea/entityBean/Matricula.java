/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entityBean;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findByCodigomatricula", query = "SELECT m FROM Matricula m WHERE m.codigomatricula = :codigomatricula")
    , @NamedQuery(name = "Matricula.findByPlaca", query = "SELECT m FROM Matricula m WHERE m.placa = :placa")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Codigo_matricula")
    private String codigomatricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Placa")
    private String placa;
    @OneToMany(mappedBy = "matricula")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<Vehiculo> vehiculoList;

    public Matricula() {
    }

    public Matricula(String codigomatricula) {
        this.codigomatricula = codigomatricula;
    }

    public Matricula(String codigomatricula, String placa) {
        this.codigomatricula = codigomatricula;
        this.placa = placa;
    }

    public String getCodigomatricula() {
        return codigomatricula;
    }

    public void setCodigomatricula(String codigomatricula) {
        this.codigomatricula = codigomatricula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigomatricula != null ? codigomatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.codigomatricula == null && other.codigomatricula != null) || (this.codigomatricula != null && !this.codigomatricula.equals(other.codigomatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entityBean.Matricula[ codigomatricula=" + codigomatricula + " ]";
    }
    
}
