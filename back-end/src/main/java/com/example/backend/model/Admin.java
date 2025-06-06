package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue

    private Integer AdminId;
    private String AdminFirstName;
    private String AdminLastName;
    private String AdminType;
    private String AdminEmail;
    private String AdminPhoneNo;
    private String username;
    private String password;

    public Integer getAdminId() {
        return AdminId;
    }

    public void setAdminId(Integer adminId) {
        AdminId = adminId;
    }

    public String getAdminFirstName() {
        return AdminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        AdminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return AdminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        AdminLastName = adminLastName;
    }

    public String getAdminType() {
        return AdminType;
    }

    public void setAdminType(String adminType) {
        AdminType = adminType;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        AdminEmail = adminEmail;
    }

    public String getAdminPhoneNo() {
        return AdminPhoneNo;
    }

    public void setAdminPhoneNo(String adminPhoneNo) {
        AdminPhoneNo = adminPhoneNo;
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
}
