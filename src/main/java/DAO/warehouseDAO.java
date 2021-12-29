package DAO;

import bean.warehouse;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 13:25
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public interface warehouseDAO {
    void insert(Connection conn, warehouse wh);

    void deleteById(Connection conn, int id);

    void update(Connection conn, warehouse wh);

    warehouse getWarehouseById(Connection conn, int id);

    List<warehouse> getAll(Connection conn);

    Long getCount(Connection conn);
}
