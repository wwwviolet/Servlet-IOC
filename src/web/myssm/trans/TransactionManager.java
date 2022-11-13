package web.myssm.trans;

import web.myssm.baseDAO.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //获取conn对象的操作放在ConnUtil里进行
    //        //获取conn对象
    //        Connection conn = threadLocal.get();
    //        if (conn==null){
    //            conn = ConnUtil.getCon();
    //            threadLocal.set(conn);
    //        }
    //开启事务
    public void beginTrans() throws SQLException {
        ConnUtil.getCon().setAutoCommit(false);

    }

    //提交事务
    public void commit() throws SQLException {
        ConnUtil.getCon().commit();

    }

    //回滚事务
    public void rollback() throws SQLException {
        ConnUtil.getCon().rollback();

    }
}
