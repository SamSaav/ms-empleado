package com.accenture.microempleado.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private long id;

    @Column(name = "EMP_FNAME")
    private String name;
    @Column(name = "EMP_LNAME")
    private String lastName;
    @Column(name = "EMP_ENTERPRISE_ID")
    private String enterpriseID;
    @Column(name = "EMP_PHONE")
    private Integer phoneNumber;
    @Column(name = "EMP_GENDER")
    private String gender;
    @Column(name = "EMP_RESOURCE_ROLE")
    private String resourceRole;
    @Column(name = "EMP_ENGLISH_LVL")
    private String englishLevel;
    @Column(name = "EMP_OFFICE_LOCATION")
    private String officeLocation;
    @Column(name = "EMP_CLIENT")
    private Long client;
    @Column(name = "EMP_PROJECT")
    private Long project;
    @Column(name = "EMP_STATUS")
    private Boolean statusEmpleado;


    public Empleado() {
    }

    public Empleado(String name, String lastName, String enterpriseID, Integer phoneNumber, String gender, String resourceRole, String englishLevel, String officeLocation) {
        this.name = name;
        this.lastName = lastName;
        this.enterpriseID = enterpriseID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.resourceRole = resourceRole;
        this.englishLevel = englishLevel;
        this.officeLocation = officeLocation;
        this.statusEmpleado = true;
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

    public Boolean getStatusEmpleado() {
        return statusEmpleado;
    }

    public void setStatusEmpleado(Boolean statusEmpleado) {
        this.statusEmpleado = statusEmpleado;
    }
}
