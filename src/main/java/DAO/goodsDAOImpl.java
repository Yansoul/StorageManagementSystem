package DAO;

import bean.goods;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 13:34
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class goodsDAOImpl extends BaseDAO implements goodsDAO {
    public void insert(Connection conn, goods g) {
        String sql = "INSERT INTO goods(goodsID,goodsName,`version`,`type`,unit)VALUES(?,?,?,?,?)";
        update(conn, sql, g.getGoodsID(), g.getGoodsName(), g.getVersion(), g.getType(), g.getUnit());
    }

    public void deleteById(Connection conn, int id) {
        String sql = "DELETE FROM goods WHERE goodsID = ?";
        update(conn, sql, id);
    }

    public void update(Connection conn, goods g) {
        String sql = "UPDATE goods SET goodsID = ?,goodsName = ?,`version` = ?, `type` = ?,unit = ?";
        update(conn, sql, g.getGoodsID(), g.getGoodsName(), g.getVersion(), g.getType(), g.getUnit());
    }

    public goods getGoodsById(Connection conn, int id) {
        String sql = "SELECT goodsID,goodsName,`version`,`type`,unit FROM goods WHERE goodsID = ?";
        return query(conn,goods.class,sql,id);
    }

    public List<goods> getAll(Connection conn) {
        String sql = "SELECT goodsID,goodsName,`version`,`type`,unit FROM goods";
        return queryForList(conn,goods.class,sql);
    }

    public Long getCount(Connection conn) {
        String sql = "SELECT COUNT(*) FROM goods";
        return getValues(conn,sql);
    }
}
