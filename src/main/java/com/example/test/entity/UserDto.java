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
    private Long matric;
    private String modeOfEntry;
    private int yearOfEntry;
    private String email;
    private String password;
    private String dob;
    private String faculty;
    private String department;
    private String gender;
    private int level;
    private String stateOfOrigin;
    private Long phoneNumber;
    private int age;
    @Column(name = "Parent/Guardian_Phone_Number")
    private Long parentPhoneNumber;
    @Column(name = "Home/Residence_Address")
    private String homeAddress;
    @Column(name = "medical_Id", nullable = false)
    private String medicalId;
    @Column (name="Local_Government")
    private String localGovernment;







}
