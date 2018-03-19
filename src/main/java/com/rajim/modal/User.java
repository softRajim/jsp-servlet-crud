package com.rajim.modal;

/**
 * @author rajim on 3/19/18
 */
public class User {

    private int id;

    private String first_name;

    private String last_name;

    private String dob;

    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: "+getFirst_name() +" "+getLast_name()+" Date of birth:: "+
                getDob()+" Email:: "+getEmail();
    }
}
