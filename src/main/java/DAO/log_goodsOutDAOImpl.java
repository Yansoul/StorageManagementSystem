package DAO;

import bean.goods;
import bean.log_goodsIn;
import bean.log_goodsOut;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 17:49
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class log_goodsOutDAOImpl extends BaseDAO implements log_goodsOutDAO{

    @Override
    public void insert(Connection conn, log_goodsOut g) {
        String sql = "INSERT INTO log_goodsout(goodsID,goodsName,`version`,`type`,unit," +
                "amount,unitPrice,figure,outPutTime,outPutManager,operator,houseID,remarks)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(conn, sql, g.getGoodsID(), g.getGoodsName(), g.getVersion(), g.getType(),
                g.getUnit(),g.getAmount(), g.getUnitPrice(),g.getFigure(),
                g.getOutPutTime(),g.getOutPutManager(),g.getOperator(),g.getHouseID(),g.getRemarks());

    }

    @Override
    public List<log_goodsOut> getAll(Connection conn) {
        String sql = "SELECT goodsID,goodsName,`version`,`type`,unit,amount,unitPrice," +
                "figure,outPutTime,outPutManager,operator,houseID,remarks FROM log_goodsout";
        return queryForList(conn, log_goodsOut.class,sql);
    }
}
