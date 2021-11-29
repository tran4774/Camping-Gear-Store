package com.example.campinggearstore.repository.impl;

import com.example.campinggearstore.entity.UserEntity;
import com.example.campinggearstore.repository.IUserRepository;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;

import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<UserEntity, ObjectId> implements IUserRepository {
    private static UserRepositoryImpl instance;

    private UserRepositoryImpl() {
        super(UserEntity.class);
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    public List<UserEntity> findByUserNameAndPassword(String username, String password) {
        return findByProps(Filters.eq("username", username),
                Filters.eq("password", password));
    }
}
