package DAO;

import bean.warehouse;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 13:33
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class warehouseDAOImpl extends BaseDAO implements warehouseDAO {
    public void insert(Connection conn, warehouse wh) {
        String sql = "INSERT INTO warehouse(HouseID,HouseName,ChargeName,`Call`,Addr)VALUES(?,?,?,?,?)";
        update(conn, sql, wh.getHouseID(), wh.getHouseName(), wh.getChargeName(), wh.getCall(), wh.getAddr());
    }

    public void deleteById(Connection conn, int id) {
        String sql = "DELETE FROM warehouse WHERE HouseID = ?";
        update(conn, sql, id);
    }

    public void update(Connection conn, warehouse wh) {
        String sql = "UPDATE warehouse SET HouseID = ?,HouseName = ?,ChargeName = ?, `Call` = ?,Addr = ?";
        update(conn, sql, wh.getHouseID(), wh.getHouseName(), wh.getChargeName(), wh.getCall(), wh.getAddr());
    }

    public warehouse getWarehouseById(Connection conn, int id) {
        String sql = "SELECT HouseID,HouseName,ChargeName,`Call`,Addr FROM warehouse WHERE HouseID = ?";
        return query(conn, warehouse.class, sql, id);
    }

    public List<warehouse> getAll(Connection conn) {
        String sql = "SELECT HouseID,HouseName,ChargeName,`Call`,Addr FROM warehouse";
        List<warehouse> list = queryForList(conn, warehouse.class, sql);
        return list;
    }

    public Long getCount(Connection conn) {
        String sql = "SELECT COUNT(*) FROM warehouse";
        return getValues(conn, sql);
    }
}
