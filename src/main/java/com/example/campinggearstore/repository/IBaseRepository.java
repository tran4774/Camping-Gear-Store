package com.example.campinggearstore.repository;

import com.mongodb.WriteResult;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import dev.morphia.Key;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.experimental.filters.Filter;

import java.io.Serializable;
import java.util.List;

public interface IBaseRepository<T, ID extends Serializable> {

    T create(T entity);

    T findByID(ID id);

    List<T> findBy(String field, Object value);

    List<T> findByProps(Filter... filters);

    T update(T entity);

    UpdateResult update(Query<T> query, UpdateOperations<T> operations);

    DeleteResult delete(T entity);

    UpdateOperations<T> createOperations();

    Query<T> createQuery();
}
