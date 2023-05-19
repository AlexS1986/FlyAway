package com.schlueter.flyaway.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class) // Specify the composite primary key class
public class AuthorityHelper {

    @Id
    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "authority")
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    // Don't forget to override the equals() and hashCode() methods if necessary

}

