package com.example.campinggearstore.repository.impl;

import com.example.campinggearstore.config.MongoDBConfig;
import com.example.campinggearstore.repository.IBaseRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

public class BaseRepositoryImpl<T, ID extends Serializable> implements IBaseRepository<T, ID> {
    Datastore datastore = MongoDBConfig.getInstance().getDatabase();
    private Class<T> t;

    public BaseRepositoryImpl() {
    }

    public BaseRepositoryImpl(Class<T> t) {
        this.t = t;
    }

    @Override
    public T create(T entity) {
        return datastore.save(entity);
    }

    @Override
    public T findByID(ID id) {
        return datastore.find(t).filter(Filters.eq("_id", new ObjectId(id.toString()))).first();
    }

    @Override
    public List<T> findBy(String field, Object value) {
        return datastore.find(t).filter(Filters.eq(field, value)).iterator().toList();
    }

    @Override
    public List<T> findByProps(Filter... filters) {
        return datastore.find(t).filter(filters).iterator().toList();
    }

    @Override
    public T update(T entity) {
        return datastore.save(entity);
    }

    @Override
    public UpdateResult update(Query<T> query, UpdateOperations<T> operations) {
        return datastore.update(query, operations);
    }

    @Override
    public DeleteResult delete(T entity) {
        return datastore.delete(entity);
    }

    @Override
    public UpdateOperations<T> createOperations() {
        return datastore.createUpdateOperations(t);
    }

    @Override
    public Query<T> createQuery() {
        return datastore.createQuery(t);
    }
}
