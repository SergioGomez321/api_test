package com.test.softtek.sgomez.repository;

import java.util.List;

public interface GenericRepository<T, K> {


    public List<T> getAll();

    public T save(T entity);




}
