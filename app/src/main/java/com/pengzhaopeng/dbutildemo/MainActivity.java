package com.pengzhaopeng.dbutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTableAndInsertData();

        queryData();

        updateData();
    }

    /**
     * 创建数据表并插入数据
     */
    protected void createTableAndInsertData(){

        User user1 = new User();
        user1.setAge(20);
        user1.setName("wocao");
        user1.setEmail("kengdie1");

        User user2 = new User();
        user2.setAge(32);
        user2.setName("nimei");
        user2.setEmail("kengdie2");

        List<User> listItem = new ArrayList<User>();
        listItem.add(user1);
        listItem.add(user2);

        try {
            MyApplication.dbUtils.saveAll(listItem);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    protected void queryData(){
        try {
            List<User> listItem = MyApplication.dbUtils.findAll(User.class);
            Log.d("queryData", "queryData: "+listItem.toString());
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    protected void updateData(){
        try {
            User user = MyApplication.dbUtils.findById(User.class, 1);
            user.setAge(80);
            MyApplication.dbUtils.update(user,"age");

            queryData();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    protected void delData(){
        User user = new User();
        user.setId(1);

        try {
            MyApplication.dbUtils.delete(user);
            queryData();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
