package com.example.campinggearstore.entity;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.PrePersist;
import dev.morphia.annotations.Version;
import org.bson.types.ObjectId;

import java.util.Date;

public abstract class BaseEntity {
    @Id
    protected ObjectId id;
    protected Date creationDate;
    protected Date lastChange;

    @Version
    private long version;

    public BaseEntity() {
        super();
    }

    public String getId() {
        return id.toString();
    }

    public long getVersion() {
        return version;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastChange() {
        return lastChange;
    }

    @PrePersist
    public void prePersist() {
        this.creationDate = (creationDate == null) ? new Date() : creationDate;
        this.lastChange = (lastChange == null) ? creationDate : new Date();
    }
}
