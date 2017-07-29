package com.admin.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author sunny
 *
 * @param <E>
 * @param <PK>
 */
public interface EntityDao<E, PK extends Serializable> {

    public E getById(PK id) throws DataAccessException;

    public int removeById(PK id) throws DataAccessException;

    /** 插入数据 */
    public int save(E entity) throws DataAccessException;

    /** 更新数据 */
    public int update(E entity) throws DataAccessException;

    /** 根据id检查是否插入或是更新数据 */
    public int saveOrUpdate(E entity) throws DataAccessException;

    public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException;

    /** 用于hibernate.flush() 有些dao实现不需要实现此类 */
    public void flush() throws DataAccessException;

    public List<E> findAll() throws DataAccessException;

}
