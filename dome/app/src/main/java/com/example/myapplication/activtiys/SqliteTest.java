package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.entity.UserSqlEntity;
import com.example.myapplication.utils.BaseData;
import com.example.myapplication.utils.OrmliteSqliteHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class SqliteTest extends AppCompatActivity implements View.OnClickListener {

    /**
     * 插入
     */
    private Button mSqlBtIn;
    /**
     * 查询
     */
    private Button mSqlBtSc;
    /**
     * 删除
     */
    private Button mSqlBtDel;
    private OrmliteSqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_test);
        initView();
        setView();
    }

    private void setView() {
        //---------sqlite操作
//        SqlitHelperDao sqlitHelperDao = new SqlitHelperDao(this);
////        sqlitHelperDao.insert();
//        sqlitHelperDao.select();
        //----------ormsqlite
        sqliteHelper = new OrmliteSqliteHelper(this);
    }

    private void initView() {
        mSqlBtIn = (Button) findViewById(R.id.sql_bt_in);
        mSqlBtIn.setOnClickListener(this);
        mSqlBtSc = (Button) findViewById(R.id.sql_bt_sc);
        mSqlBtSc.setOnClickListener(this);
        mSqlBtDel = (Button) findViewById(R.id.sql_bt_del);
        mSqlBtDel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            Dao<UserSqlEntity, ?> dao = sqliteHelper.getDao(UserSqlEntity.class);
        switch (v.getId()) {
            default:
                break;
            case R.id.sql_bt_in:
                UserSqlEntity userSqlEntity = new UserSqlEntity();
                userSqlEntity.setName("张三2");
                userSqlEntity.setPwd("000");
                userSqlEntity.setAge("20");
                dao.create(userSqlEntity);
                Log.d(BaseData.LOG_TOAST, "orm插入user2数据成功");
                break;
            case R.id.sql_bt_sc:
                List<UserSqlEntity> userSqlEntities = dao.queryForAll();
                Log.d(BaseData.LOG_TOAST, "orm查询user2数据成功");
                Log.d(BaseData.LOG_TOAST, userSqlEntities.toString());
                break;
            case R.id.sql_bt_del:
                DeleteBuilder<UserSqlEntity, ?> userSqlEntityDeleteBuilder = dao.deleteBuilder();
                userSqlEntityDeleteBuilder.where().eq("name","张三2");
                userSqlEntityDeleteBuilder.delete();
                Log.d(BaseData.LOG_TOAST, "orm删除user2数据成功");
                break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(BaseData.LOG_TOAST, "orm操作失败"+e.toString());
        }
    }
}