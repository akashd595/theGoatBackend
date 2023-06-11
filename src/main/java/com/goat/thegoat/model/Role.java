package com.goat.thegoat.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    @JsonIgnore
    private Set<UserRoles> userRolesSet = new HashSet<>();

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(){

    }

    public Role(Long id, String roleName, Set<UserRoles> userRolesSet) {
        this.id = id;
        this.roleName = roleName;
        this.userRolesSet = userRolesSet;
    }

    public Set<UserRoles> getUserRolesSet() {
        return userRolesSet;
    }

    public void setUserRolesSet(Set<UserRoles> userRolesSet) {
        this.userRolesSet = userRolesSet;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userRolesSet=" + userRolesSet +
                '}';
    }
}

