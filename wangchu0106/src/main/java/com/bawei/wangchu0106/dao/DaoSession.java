package com.bawei.wangchu0106.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bawei.wangchu0106.greenDao;

import com.bawei.wangchu0106.dao.greenDaoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig greenDaoDaoConfig;

    private final greenDaoDao greenDaoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        greenDaoDaoConfig = daoConfigMap.get(greenDaoDao.class).clone();
        greenDaoDaoConfig.initIdentityScope(type);

        greenDaoDao = new greenDaoDao(greenDaoDaoConfig, this);

        registerDao(greenDao.class, greenDaoDao);
    }
    
    public void clear() {
        greenDaoDaoConfig.clearIdentityScope();
    }

    public greenDaoDao getGreenDaoDao() {
        return greenDaoDao;
    }

}
