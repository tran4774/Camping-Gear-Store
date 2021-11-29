package com.example.campinggearstore.entity;

import com.example.campinggearstore.entity.user.embedded.Cart;
import com.example.campinggearstore.entity.user.embedded.PersonalInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.morphia.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity("users")
public class UserEntity extends BaseEntity implements Serializable {
    @Indexed(options = @IndexOptions(unique = true))
    private String email;
    @JsonIgnore
    private String password;
    @Property
    private PersonalInfo personalInfo;
    @Property
    private Cart cart;
    @JsonIgnore
    private boolean isAdmin = false;
}
