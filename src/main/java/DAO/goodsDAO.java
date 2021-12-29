package DAO;

import bean.goods;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 13:25
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public interface goodsDAO {
    void insert(Connection conn, goods g);

    void deleteById(Connection conn, int id);

    void update(Connection conn, goods g);

    goods getGoodsById(Connection conn, int id);

    List<goods> getAll(Connection conn);

    Long getCount(Connection conn);
}
