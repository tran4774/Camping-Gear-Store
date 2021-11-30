package com.example.campinggearstore.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;


public abstract class BaseEntity implements Serializable {
    @Id
    protected String id;
    @CreatedDate
    @Field(value = "creationDate")
    protected Date creationDate;
    @LastModifiedDate
    @Field(value = "lastChange")
    protected Date lastChange;
    @Field(value = "_v")
    @Version
    private Long version;

    public BaseEntity() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public Long getVersion() {
        return version;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastChange() {
        return lastChange;
    }
}
