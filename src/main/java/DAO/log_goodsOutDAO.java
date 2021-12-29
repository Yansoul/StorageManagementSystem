package DAO;

import bean.goods;
import bean.log_goodsOut;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 17:48
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public interface log_goodsOutDAO {
    void insert(Connection conn, log_goodsOut g);

    List<log_goodsOut> getAll(Connection conn);
}
