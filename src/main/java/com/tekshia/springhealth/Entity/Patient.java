package com.tekshia.springhealth.Entity;

import com.tekshia.springhealth.Helpers.Calculate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAmount;
import java.util.Date;

@Entity(name = "patient")
public class Patient {
    /*Important Data*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;            //DNI
    /*Relative Data*/
    @Column(name = "firstName")
    private String firstName;   //Patient FirstName
    @Column
    private String lastName;    //Patient LastName
    @Column
    private String gender;      //Male/Female   Genero
    @ManyToOne
    private Nation nationality; //Nationality   (MayBe Future Object)
//    @OneToOne
    @Column
    private String district;    //District  -   Distrito
//    @OneToOne
    @Column
    private String city;        //City      -   Ciudad
    @Column
    private String birthPlace;  //Birth Place   Lugar de Nacimiento
    /*Dates Data*/
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;      //Born Date    Fecha de Nacimiento
    /*Calculate*/
    private int age;            //Function to getAge
    /*Access Data*/
    @Column
    private int phoneNumber;    //Phone Number

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Nation getNationality() {
        return nationality;
    }

    public void setNationality(Nation nationality) {
        this.nationality = nationality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int kk = Calculate.getAge(getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        this.age = kk;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
