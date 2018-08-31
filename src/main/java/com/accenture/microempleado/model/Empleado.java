package com.accenture.microempleado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastName;
    private String enterpriseID;
    private Integer phoneNumber;
    private String gender;
    private String resourceRole;
    private String englishLevel;
    private String officeLocation;
    private Long client;
    private Long project;


    public Empleado() {
    }

<<<<<<< Updated upstream

    public Empleado(String name, String lastName, String enterpriseID, Integer phoneNumber, String gender, String resourceRole, String englishLevel, String officeLocation) {
=======
    public Empleado(String name, String lastName, String enterpriseID, Integer phoneNumber, String gender, String resourceRole, String englishLevel, String officeLocation, Boolean statusEmpleado) {
>>>>>>> Stashed changes
        this.name = name;
        this.lastName = lastName;
        this.enterpriseID = enterpriseID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.resourceRole = resourceRole;
        this.englishLevel = englishLevel;
        this.officeLocation = officeLocation;
    }









    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResourceRole() {
        return resourceRole;
    }

    public void setResourceRole(String resourceRole) {
        this.resourceRole = resourceRole;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }
}
