
package com.sudokubase.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "countries")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCode2", query = "SELECT c FROM Countries c WHERE c.code2 = :code2")
    , @NamedQuery(name = "Countries.findByName", query = "SELECT c FROM Countries c WHERE c.name = :name")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "code2")
    private String code2;
    @Size(max = 52)
    @Column(name = "name")
    private String name;

    public Countries() {
    }

    public Countries(String code2) {
        this.code2 = code2;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code2 != null ? code2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.code2 == null && other.code2 != null) || (this.code2 != null && !this.code2.equals(other.code2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.dema.entity.Countries[ code2=" + code2 + " ]";
    }

}
