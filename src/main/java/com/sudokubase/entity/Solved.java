
package com.sudokubase.entity;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "solved")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solved.findAll", query = "SELECT s FROM Solved s")
    , @NamedQuery(name = "Solved.findById", query = "SELECT s FROM Solved s WHERE s.id = :id")
    , @NamedQuery(name = "Solved.findBySuspicious", query = "SELECT s FROM Solved s WHERE s.suspicious = :suspicious")
    , @NamedQuery(name = "Solved.findByDuration", query = "SELECT s FROM Solved s WHERE s.duration = :duration")
    , @NamedQuery(name = "Solved.findByDatesolved", query = "SELECT s FROM Solved s WHERE s.datesolved = :datesolved")})
public class Solved implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "uid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users user;
    @JoinColumn(name = "pid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Puzzles puzzle;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "suspicious")
    private int suspicious;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private long duration;
    @Basic(optional = false)
    @Column(name = "datesolved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesolved;

    public Solved() {
    }

    public Solved(Long id) {
        this.id = id;
    }

    public Solved(Users user, Puzzles puzzle, int suspicious, long duration) {
        this.user = user;
        this.puzzle = puzzle;
        this.suspicious = suspicious;
        this.duration = duration;
       
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Puzzles getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzles puzzle) {
        this.puzzle = puzzle;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSuspicious() {
        return suspicious;
    }

    public void setSuspicious(int suspicious) {
        this.suspicious = suspicious;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Date getDatesolved() {
        return datesolved;
    }

    public void setDatesolved(Date datesolved) {
        this.datesolved = datesolved;
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
        if (!(object instanceof Solved)) {
            return false;
        }
        Solved other = (Solved) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.dema.entity.Solved[ id=" + id + " ]";
    }

}
