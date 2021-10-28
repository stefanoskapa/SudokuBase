
package com.sudokubase.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "puzzles")


public class Puzzles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 81)
    @Column(name = "puzzle")
    private String puzzle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clues")
    private short clues;
    @Size(max = 60)
    @Column(name = "creator")
    private String creator;
   /* @Basic(optional = false)
    @NotNull*/
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Size(max=200)
    @Column(name="Notes")
    private String notes;

    public Puzzles() {
    }

    public Puzzles(Integer id) {
        this.id = id;
    }

    public Puzzles(String puzzle, short clues) {
        this.puzzle = puzzle;
        this.clues = clues;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public short getClues() {
        return clues;
    }

    public void setClues(short clues) {
        this.clues = clues;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
        if (!(object instanceof Puzzles)) {
            return false;
        }
        Puzzles other = (Puzzles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.dema.entity.Puzzles[ id=" + id + " ]";
    }

}
