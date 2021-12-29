package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Yansoul
 * @Description 操作数据库的工具类
 * @date 2021/12/28 - 10:33
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class JDBCUtils {

    private static DataSource source;

    static {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 使用Druid连接池技术获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = source.getConnection();
        return conn;
    }

    /**
     * @param conn
     * @param ps
     * @Description 关闭资源的操作1
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param ps
     * @param rs
     * @Description 关闭资源的操作2
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
