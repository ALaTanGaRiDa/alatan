package com.jiyuns.alatan_kaoshi.utils;

import android.app.Application;

import com.jiyuns.alatan_kaoshi.dao.DaoMaster;
import com.jiyuns.alatan_kaoshi.dao.DaoSession;

/**
 * 阿拉坦   H1810B
 * Date: 2019/6/13
 * Time: 12:02
 */
public class MyApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "food.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
