package com.example.test.service;

import com.example.test.entity.UserDto;
import com.example.test.repository.UserRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     private final UserRepository userRepository;
    private  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto registerUser(      String firstName,

  String lastName,
      Long matric,
    String modeOfEntry,
    int yearOfEntry,
     String email,
      String password,
     String dob,
     String faculty,
     String department,
      String gender,
      int level,
   String stateOfOrigin,
  Long phoneNumber,
     int age, Long parentPhoneNumber,
    String homeAddress,
    String medicalId,
    String localGovernment
                              ){
        if (matric ==null || password ==null){
            return null;
        } else{

            if(userRepository.findFirstByMatric(matric).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            UserDto userDto = new UserDto();
            userDto.setFirstName(firstName);
            userDto.setLastName(lastName);
            userDto.setMatric(matric);
            userDto.setModeOfEntry(modeOfEntry);
            userDto.setEmail(email);
            userDto.setPassword(password);
            userDto.setDob(dob);
            userDto.setYearOfEntry(yearOfEntry);
            userDto.setStateOfOrigin(stateOfOrigin);
            userDto.setPhoneNumber(phoneNumber);
            userDto.setLevel(level);
            userDto.setGender(gender);
            userDto.setFaculty(faculty);
            userDto.setDepartment(department);
            userDto.setAge(age);
            userDto.setParentPhoneNumber( parentPhoneNumber);
            userDto.setHomeAddress(homeAddress);
            userDto.setMedicalId(medicalId);
            userDto.setLocalGovernment(localGovernment);


            return userRepository.save(userDto);



        }

    }

    public UserDto authenticate (Long matric, String password){
        return  userRepository.findByMatricAndPassword(matric,password).orElse(null);
    }
}
