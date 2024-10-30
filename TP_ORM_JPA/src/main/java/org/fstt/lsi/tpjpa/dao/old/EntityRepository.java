package org.fstt.lsi.tpjpa.dao.old;

import java.util.List;

public interface EntityRepository<T> {
    public T save(T p);
    public List<T> findAll();
    public List<T> findByDesignation(String mc);
    public T findOne(Long id);
    public T update(T p);
    public void delete(Long id);
}