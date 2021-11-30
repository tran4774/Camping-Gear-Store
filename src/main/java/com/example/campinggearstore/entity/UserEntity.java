package com.example.campinggearstore.entity;

import com.example.campinggearstore.entity.user.embedded.Cart;
import com.example.campinggearstore.entity.user.embedded.PersonalInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserEntity extends BaseEntity implements Serializable {
    @Indexed
    @Field(value = "email")
    private String email;
    @Field(value = "password")
    private String password;
    @Field(value = "isAdmin")
    private Boolean isAdmin;
    @Field(value = "personalInfo")
    private PersonalInfo personalInfo;
    @Field(value = "cart")
    private Cart cart;
}
