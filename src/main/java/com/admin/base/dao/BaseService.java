package com.admin.base.dao;
import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author sunny
 *
 * @param <E>
 * @param <PK>
 */
@Transactional
public abstract class BaseService<E, PK extends Serializable> {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected abstract EntityDao<E, PK> getEntityDao();

    @Transactional(readOnly = true)
    public Object getById(PK id) throws DataAccessException {
        return getEntityDao().getById(id);
    }

    @Transactional(readOnly = true)
    public List<E> findAll() throws DataAccessException {
        return getEntityDao().findAll();
    }

    /** 根据id检查是否插入或是更新数据 */
    public void saveOrUpdate(E entity) throws DataAccessException {
        getEntityDao().saveOrUpdate(entity);
    }

    /** 插入数据 */
    public void save(E entity) throws DataAccessException {
        getEntityDao().save(entity);
    }

    public void removeById(PK id) throws DataAccessException {
        getEntityDao().removeById(id);
    }

    public void update(E entity) throws DataAccessException {
        getEntityDao().update(entity);
    }

    @Transactional(readOnly = true)
    public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException {
        return getEntityDao().isUnique(entity, uniquePropertyNames);
    }

}
