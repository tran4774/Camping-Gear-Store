package com.example.campinggearstore.repository;

import com.example.campinggearstore.entity.UserEntity;
import com.example.campinggearstore.repository.impl.BaseRepositoryImpl;
import org.bson.types.ObjectId;

public interface IUserRepository extends IBaseRepository<UserEntity, ObjectId>{

}
