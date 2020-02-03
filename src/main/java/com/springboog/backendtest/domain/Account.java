package com.springboog.backendtest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    public enum Type {
        PLATINUM, GOLD, SILVER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERNAME", nullable = false, length = 10)
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false, length = 80)
    private String password;

    @Column(name = "DISABLED")
    private boolean disabled = false;

    @Version
    @Column(name = "VERSIONS", nullable = false)
    private Integer versions;

    @Column(name = "SALARY", nullable = false)
    private int salary;

    @Column(name = "REFERENCE_CODE", nullable = false)
    private String referenceCode;

    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getReferenceCode() {
        return this.referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", disabled=" + disabled +
                ", versions=" + versions +
                ", salary=" + salary +
                ", referenceCode='" + referenceCode + '\'' +
                ", type=" + type +
                '}';
    }
}
