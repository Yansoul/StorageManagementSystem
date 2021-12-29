package DAO;

import bean.manager;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 13:25
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public interface managerDAO {
    void insert(Connection conn, manager m);

    void deleteById(Connection conn, int id);

    void update(Connection conn, manager m);

    manager getManagerById(Connection conn, int id);

    List<manager> getAll(Connection conn);

    Long getCount(Connection conn);
}
