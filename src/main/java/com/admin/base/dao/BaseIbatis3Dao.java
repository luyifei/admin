package com.admin.base.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

import com.admin.base.entity.BaseQuery;
import com.admin.base.util.PropertyUtils;


/**
 * 
 * @author sunny
 *
 * @param <E>
 * @param <PK>
 */
public abstract class BaseIbatis3Dao<E, PK extends Serializable> extends DaoSupport implements EntityDao<E, PK> {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    protected void checkDaoConfig() throws IllegalArgumentException {
        Assert.notNull(sqlSessionFactory, "sqlSessionFactory must be not null");
    }
    
    @Override
    protected void initDao() throws Exception {
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        super.initDao();
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    public Object getById(PK primaryKey) {
        Object object = getSqlSessionTemplate().selectOne(getFindByPrimaryKeyStatement(), primaryKey);
        return object;
    }
    @Override
    public void removeById(PK id) {
        int affectCount = getSqlSessionTemplate().delete(getDeleteStatement(), id);
    }
    @Override
    public void save(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        int affectCount = getSqlSessionTemplate().insert(getInsertStatement(), entity);
    }
    @Override
    public void update(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        int affectCount = getSqlSessionTemplate().update(getUpdateStatement(), entity);
    }
    

    /**
     * 用于子类覆盖,在insert,update之前调用
     * @param o
     */
    protected void prepareObjectForSaveOrUpdate(E o) {
    }

    public String getIbatisMapperNamesapce() {
        throw new RuntimeException("not yet implement");
    }

    public String getFindByPrimaryKeyStatement() {
        return getIbatisMapperNamesapce() + "_getById";
    }

    public String getInsertStatement() {
        return getIbatisMapperNamesapce() + "_insert";
    }

    public String getUpdateStatement() {
        return getIbatisMapperNamesapce() + ".update";
    }

    public String getDeleteStatement() {
        return getIbatisMapperNamesapce() + ".delete";
    }

    public String getCountStatementForPaging(String statementName) {
        return statementName + "_count";
    }

    protected <T> Page<T> pageQuery(String statementName, BaseQuery baseQuery) {
        return pageQuery(getSqlSessionTemplate(), statementName, getCountStatementForPaging(statementName), baseQuery);
    }

    @SuppressWarnings("unchecked")
    public static <T> Page<T> pageQuery(SqlSessionTemplate sqlSessionTemplate, String statementName,
            String countStatementName, BaseQuery baseQuery) {
        //统计总记录数
        Number totalCount = (Number) sqlSessionTemplate.selectOne(countStatementName, baseQuery);
        if (totalCount == null || totalCount.longValue() <= 0) {
            return new Page<T>(baseQuery, 0);
        }

        Page<T> page = new Page<T>(baseQuery, totalCount.intValue());

        // 其它分页参数,用于不喜欢或是因为兼容性而不使用方言(Dialect)的分页用户使用. 与getSqlMapClientTemplate().queryForList(statementName, parameterObject)配合使用
        Map<String, Object>  filters = new HashMap<String, Object>();
        filters.put("offset", page.getFirstResult());
        filters.put("pageSize", page.getPageSize());
        filters.put("lastRows", page.getFirstResult() + page.getPageSize());
        filters.put("sortColumns", baseQuery.getSortColumns());

        Map<String, Object> parameterObject = PropertyUtils.describe(baseQuery);
        filters.putAll(parameterObject);

        List<T> list = sqlSessionTemplate.selectList(statementName, filters, page.getFirstResult(), page.getPageSize());
        page.setResult(list);
        return page;
    }
    @Override
    public List<E> findAll() {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean isUnique(E entity, String uniquePropertyNames) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void flush() {
        // ignore
    }
    @Override
    public void saveOrUpdate(E entity) {
        throw new UnsupportedOperationException();
    }

    public static class SqlSessionTemplate {

        SqlSessionFactory sqlSessionFactory;

        public SqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
            this.sqlSessionFactory = sqlSessionFactory;
        }

        public Object execute(SqlSessionCallback action) {
            SqlSession session = null;
            try {
                session = sqlSessionFactory.openSession();
                Object result = action.doInSession(session);
                return result;
            } finally {
                if (session != null)
                    session.close();
            }
        }

        public Object selectOne(final String statement, final Object parameter) {
            return execute(new SqlSessionCallback() {

                public Object doInSession(SqlSession session) {
                    return session.selectOne(statement, parameter);
                }
            });
        }

        public List selectList(final String statement, final Object parameter, final int offset, final int limit) {
            return (List) execute(new SqlSessionCallback() {

                public Object doInSession(SqlSession session) {
                    return session.selectList(statement, parameter, new RowBounds(offset, limit));
                }
            });
        }

        public List selectList(final String statement, final Object parameter) {
            return (List) execute(new SqlSessionCallback() {

                public Object doInSession(SqlSession session) {
                    return session.selectList(statement, parameter);
                }
            });
        }

        public int delete(final String statement, final Object parameter) {
            return (Integer) execute(new SqlSessionCallback() {

                public Object doInSession(SqlSession session) {
                    return session.delete(statement, parameter);
                }
            });
        }

        public int update(final String statement, final Object parameter) {
            return (Integer) execute(new SqlSessionCallback() {

                public Object doInSession(SqlSession session) {
                    return session.update(statement, parameter);
                }
            });
        }

        public int insert(final String statement, final Object parameter) {
            return (Integer) execute(new SqlSessionCallback() {

                public Object doInSession(SqlSession session) {
                    return session.insert(statement, parameter);
                }
            });
        }
    }

    public static interface SqlSessionCallback {

        public Object doInSession(SqlSession session);

    }

}
