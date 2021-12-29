package DAO;

import bean.manager;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 13:33
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class managerDAOImpl extends BaseDAO implements managerDAO {
    public void insert(Connection conn, manager m) {
        String sql = "INSERT INTO manager(managerID,managerName,managerCall)VALUES(?,?,?)";
        update(conn, sql, m.getManagerID(), m.getManagerName(), m.getManagerCall());
    }

    public void deleteById(Connection conn, int id) {
        String sql = "DELETE FROM manager WHERE managerID = ?";
        update(conn, sql, id);
    }

    public void update(Connection conn, manager m) {
        String sql = "UPDATE manager SET managerID = ?,managerName = ?,managerCall = ?";
        update(conn, sql, m.getManagerID(), m.getManagerName(), m.getManagerCall());
    }

    public manager getManagerById(Connection conn, int id) {
        String sql = "SELECT managerID,managerName,managerCall FROM manager WHERE managerID = ?";
        return query(conn, manager.class, sql, id);
    }

    public List<manager> getAll(Connection conn) {
        String sql = "SELECT managerID,managerName,managerCall FROM manager";
        return queryForList(conn,manager.class,sql);
    }

    public Long getCount(Connection conn) {
        String sql = "SELECT COUNT(*) FROM manager";
        return getValues(conn,sql);
    }
}
