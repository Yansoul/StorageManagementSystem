package DAO;

import bean.goods;
import bean.log_goodsIn;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 17:48
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class log_goodsInDAOImpl extends BaseDAO implements log_goodsInDAO{
    @Override
    public void insert(Connection conn, log_goodsIn g) {
        String sql = "INSERT INTO log_goodsin(goodsID,goodsName,`version`,`type`,unit," +
                "amount,unitPrice,figure,inPutTime,inPutManager,operator,houseID,remarks)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(conn, sql, g.getGoodsID(), g.getGoodsName(), g.getVersion(), g.getType(),
                g.getUnit(),g.getAmount(), g.getUnitPrice(),g.getFigure(),
                g.getInPutTime(),g.getInPutManager(),g.getOperator(),g.getHouseID(),g.getRemarks());
    }

    @Override
    public List<log_goodsIn> getAll(Connection conn) {
        String sql = "SELECT goodsID,goodsName,`version`,`type`,unit,amount,unitPrice," +
                "figure,inPutTime,inPutManager,operator,houseID,remarks FROM log_goodsin";
        return queryForList(conn, log_goodsIn.class,sql);
    }
}
