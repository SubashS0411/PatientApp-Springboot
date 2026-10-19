package com.loq.student_app.dto;

public class PatientResponseDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private  String dataofBirth;
    private String registerdate;

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDataofBirth() {
        return dataofBirth;
    }

    public void setDataofBirth(String dataofBirth) {
        this.dataofBirth = dataofBirth;
    }
}
