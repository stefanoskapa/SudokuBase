
package com.sudokubase.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "users_puzzles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersPuzzles.findAll", query = "SELECT u FROM UsersPuzzles u")
    , @NamedQuery(name = "UsersPuzzles.findByUid", query = "SELECT u FROM UsersPuzzles u WHERE u.usersPuzzlesPK.uid = :uid")
    , @NamedQuery(name = "UsersPuzzles.findByPid", query = "SELECT u FROM UsersPuzzles u WHERE u.usersPuzzlesPK.pid = :pid")
    , @NamedQuery(name = "UsersPuzzles.findByVote", query = "SELECT u FROM UsersPuzzles u WHERE u.vote = :vote")})
public class UsersPuzzles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersPuzzlesPK usersPuzzlesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vote")
    private boolean vote;

    public UsersPuzzles() {
    }

    public UsersPuzzles(UsersPuzzlesPK usersPuzzlesPK) {
        this.usersPuzzlesPK = usersPuzzlesPK;
    }

    public UsersPuzzles(UsersPuzzlesPK usersPuzzlesPK, boolean vote) {
        this.usersPuzzlesPK = usersPuzzlesPK;
        this.vote = vote;
    }

    public UsersPuzzles(long uid, int pid) {
        this.usersPuzzlesPK = new UsersPuzzlesPK(uid, pid);
    }

    public UsersPuzzlesPK getUsersPuzzlesPK() {
        return usersPuzzlesPK;
    }

    public void setUsersPuzzlesPK(UsersPuzzlesPK usersPuzzlesPK) {
        this.usersPuzzlesPK = usersPuzzlesPK;
    }

    public boolean getVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersPuzzlesPK != null ? usersPuzzlesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPuzzles)) {
            return false;
        }
        UsersPuzzles other = (UsersPuzzles) object;
        if ((this.usersPuzzlesPK == null && other.usersPuzzlesPK != null) || (this.usersPuzzlesPK != null && !this.usersPuzzlesPK.equals(other.usersPuzzlesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.dema.entity.UsersPuzzles[ usersPuzzlesPK=" + usersPuzzlesPK + " ]";
    }

}
