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
public interface log_goodsInDAO {
    void insert(Connection conn, log_goodsIn g);

    List<log_goodsIn> getAll(Connection conn);
}
