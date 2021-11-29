package com.example.campinggearstore.entity.user.embedded;

import dev.morphia.annotations.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonalInfo implements Serializable {
    enum Sex {Mr, Mrs, Ms}
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Sex sex;
    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private String additionalInfo;
    private String country;
}
