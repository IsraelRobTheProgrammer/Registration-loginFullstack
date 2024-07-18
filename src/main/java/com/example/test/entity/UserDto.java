package com.example.test.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;






@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table (name ="users_table")
 @Entity
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "First Name", nullable = false)
    private String firstName;
    @Column(name = "Last Name", nullable = false)
    private String lastName;
    @Column(name = "Matric Number", nullable = false, unique = true)
    private Long matric;
    @Column(name = "Mode of Entry", nullable = false)
    private String modeOfEntry;
    @Column(name = "Year of Entry", nullable = false)
    private int yearOfEntry;
    @Column(name = "Email Address", nullable = false, unique = true)
    private String email;
    @Column(name = "Password", nullable = false, unique = true)
    private String password;

    private String dob;
    @Column(name = "Faculty", nullable = false)
    private String faculty;
    @Column(name = "Department", nullable = false)
    private String department;
    @Column(name = "Gender", nullable = false)
    private String gender;
    @Column(name = "Academic_level", nullable = false)
    private int level;
    @Column(nullable = false)
    private String stateOfOrigin;
    @Column( nullable = false)
    private Long phoneNumber;
    @Column( nullable = false)
    private int age;
    @Column(name = "Parent/Guardian_Phone_Number", nullable = false)
    private Long parentPhoneNumber;
    @Column(name = "Home/Residence_Address", nullable = false)
    private String homeAddress;
    @Column(name = "medical_Id", nullable = false)
    private String medicalId;
    @Column (name="Local_Government", nullable = false)
    private String localGovernment;







}
