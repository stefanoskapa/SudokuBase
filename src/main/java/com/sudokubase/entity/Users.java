
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long userid;
    
  
    @Basic(optional = false)
    @Pattern(regexp = "[0-9a-zA-Z-_]*", message = "Invalid Username")
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "username")
    private String username;
    
    @NotNull
    @Size(min = 6, max = 68)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?", message = "Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Size(max=30)
    @Column(name = "fname")
    private String fname;
    
    @Size(max=30)
    @Column(name = "lname")
    private String lname;
    
   
    //@Size(max=2)
    @JoinColumn(name = "country", referencedColumnName = "code2")
    @ManyToOne(optional = true)  
    private Countries country;
    
    @Column(name = "elo")
    private Integer elo;
    
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles role;
    
    @Column(name = "membersince")
    private Date memberSince;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, boolean enabled, String email) {
        this.username = username;
        this.enabled = enabled;
        this.email = email;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Integer getElo() {
        return elo;
    }

    public void setElo(Integer elo) {
        this.elo = elo;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Users{" + "userid=" + userid + ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", country=" + country + ", elo=" + elo + ", role=" + role + ", memberSince=" + memberSince + '}';
    }

    
}
