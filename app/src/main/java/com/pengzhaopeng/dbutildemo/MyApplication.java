package com.pengzhaopeng.dbutildemo;

import android.app.Application;

import com.lidroid.xutils.DbUtils;

/**
 * Created by 鹏鹏鹏先森 on 2016/1/20.
 */
public class MyApplication extends Application{

    //定义一个全局的DBUtils
    public static DbUtils dbUtils;

    @Override
    public void onCreate() {
        super.onCreate();

        creatDbUtils();

//        createDBUtilsWithDef();

        createDBUtilsWithCfg();
    }

    /**
     * 创建Dbutils，不带任何配置
     */
    protected void creatDbUtils(){
        dbUtils = DbUtils.create(getApplicationContext());
    }

    /**
     * 创建数据库，指定数据库的路径和名字
     */
    protected void createDBUtilsWithDef(){
        dbUtils = DbUtils.create(
                getApplicationContext(),
                "/sdcard/xutils",
                "mydb.db");
    }

    /**
     * 创建数据库，使用配置
     */
    protected void createDBUtilsWithCfg(){
        DbUtils.DaoConfig daoConfig = new DbUtils.DaoConfig(getApplicationContext());
        daoConfig.setDbDir("/sdcard/xutils");
        daoConfig.setDbName("mydb.db");

        dbUtils = DbUtils.create(daoConfig);
    }

}
