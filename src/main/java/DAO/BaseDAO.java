package DAO;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yansoul
 * @Description 封装了针对数据表的通用操作
 * @date 2021/12/28 - 13:10
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public abstract class BaseDAO {
    /**
     * @param sql
     * @param args
     * @throws Exception
     * @Description 通用的增删改操作
     */
    public void update(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //用PreparedStatement预编译SQL语句，返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            JDBCUtils.closeResource(null, ps);
        }
    }

    /**
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @Description 针对于不同表的通用的查询操作，返回一个对象
     */
    public <T> T query(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                //查到结果后，造个对象用于存储结果数据
                T t = clazz.getDeclaredConstructor().newInstance();

                //在t中存入查询结果
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的columnLabel属性，赋值为columnValue，使用反射
                    Field field = t.getClass().getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    /**
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @Description 针对于不同表的通用的查询操作，返回多个集合
     */
    public <T> List<T> queryForList(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象，用于返回查询结果
            List<T> list = new ArrayList();
            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象的columnLabel属性赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    /**
     * @param conn
     * @param sql
     * @param args
     * @param <E>
     * @return
     * @Description 用于查询特殊值的通用方法
     */
    public <E> E getValues(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}
