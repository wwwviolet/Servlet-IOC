package web.myssm.baseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtil {
    //2
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/cat_db2?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&rewriteBatchedStatements=true";
    public static final String USER = "root";
    public static final String PWD = "000000" ;


    public static Connection createConn(){
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static Connection getCon(){
        //获取conn对象
        Connection conn = threadLocal.get();
        if (conn==null){
            conn = createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }
}
