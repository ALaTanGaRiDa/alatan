package com.jiyuns.alatan_kaoshi.utils;

import com.jiyuns.alatan_kaoshi.bean.DataBean;
import com.jiyuns.alatan_kaoshi.dao.DaoSession;
import com.jiyuns.alatan_kaoshi.dao.DataBeanDao;

import java.util.List;

/**
 * 阿拉坦   H1810B
 * Date: 2019/6/13
 * Time: 12:04
 */
public class DbUtils {

    private static DaoSession daoSession;

    public static void insert(DataBean dataBean){
        if (queryOne(dataBean) == null){
            daoSession.insert(dataBean);
        }
    }

    public static List<DataBean> queryAll(){
        return daoSession.loadAll(DataBean.class);
    }

    public static DataBean queryOne(DataBean dataBean){
        daoSession = MyApp.getDaoSession();
        return daoSession.queryBuilder(DataBean.class)
                .where(DataBeanDao.Properties.Title.eq(dataBean.getTitle()))
                .build()
                .unique();
    }
}
