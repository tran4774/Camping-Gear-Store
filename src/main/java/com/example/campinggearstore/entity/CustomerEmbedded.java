package com.example.campinggearstore.entity;

import java.util.Date;

public class CustomerEmbedded {
    enum Sex {MALE, FEMALE}
    private String name;
    private Date birthday;
    private Sex sex;
    private String phoneNumber;
    private String homeAddress;

}
