package com.example.campinggearstore.entity;

import dev.morphia.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnore;

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
}
