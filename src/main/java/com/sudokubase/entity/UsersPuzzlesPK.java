
package com.sudokubase.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class UsersPuzzlesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "uid")
    private long uid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pid")
    private int pid;

    public UsersPuzzlesPK() {
    }

    public UsersPuzzlesPK(long uid, int pid) {
        this.uid = uid;
        this.pid = pid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) uid;
        hash += (int) pid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPuzzlesPK)) {
            return false;
        }
        UsersPuzzlesPK other = (UsersPuzzlesPK) object;
        if (this.uid != other.uid) {
            return false;
        }
        if (this.pid != other.pid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.dema.entity.UsersPuzzlesPK[ uid=" + uid + ", pid=" + pid + " ]";
    }

}
