package service;

import DAO.goodsDAOImpl;
import DAO.log_goodsInDAOImpl;
import DAO.log_goodsOutDAOImpl;
import bean.goods;
import bean.log_goodsIn;
import bean.log_goodsOut;
import bean.manager;
import util.UIUtils;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 14:56
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class DoGoods {
    Connection conn;

    DoGoods(Connection conn) {
        this.conn = conn;
    }

    public void choose() {
        goodsDAOImpl operate = new goodsDAOImpl();
        boolean flag = true;
        int choiceG;
        while (flag) {
            UIUtils.goodsChoose();
            choiceG = UIUtils.makeRightChoice(1, 6);
            switch (choiceG) {
                case 1:
                    goods toInsert = this.goodsInstance();

                    //入库日志记录
                    log_goodsIn toLog = this.putInGoodsInstance(toInsert);
                    new log_goodsInDAOImpl().insert(conn, toLog);

                    operate.insert(conn, toInsert);
                    System.out.println("入库成功");
                    break;
                case 2:
                    System.out.println("请输入要出库的ID：");
                    int id = UIUtils.sc.nextInt();
                    goods goingToOut = operate.getGoodsById(conn, id);
                    operate.deleteById(conn, id);

                    //出库日志记录
                    log_goodsOut toLog2 = this.putOutGoodsInstance(goingToOut);
                    new log_goodsOutDAOImpl().insert(conn, toLog2);
                    System.out.println("删除成功");
                    break;
                case 3:
                    List<goods> list = operate.getAll(conn);
                    if (list != null && list.size() != 0) {
                        for (goods w : list)
                            System.out.println(w.toString());
                    } else
                        System.out.println("在库物资为空！");
                    break;
                case 4:
                    System.out.println("**********入库日志**********");
                    List<log_goodsIn> listIn = new log_goodsInDAOImpl().getAll(conn);
                    if (listIn != null && listIn.size() != 0) {
                        for (log_goodsIn w : listIn)
                            System.out.println(w.toString());
                    } else
                        System.out.println("入库日志为空！");
                    break;
                case 5:
                    System.out.println("**********出库日志**********");
                    List<log_goodsOut> listOut = new log_goodsOutDAOImpl().getAll(conn);
                    if (listOut != null && listOut.size() != 0) {
                        for (log_goodsOut w : listOut)
                            System.out.println(w.toString());
                    } else
                        System.out.println("出库日志为空！");
                    break;
                case 6:
                    flag = false;
                    System.out.println("返回成功");
            }
        }
    }

    private goods goodsInstance() {
        goodsDAOImpl operate = new goodsDAOImpl();

        int goodsID;
        String goodsName, version, type, unit;

        System.out.print("请输入物资编号：");
        goodsID = UIUtils.sc.nextInt();

        while (operate.getGoodsById(conn, goodsID) != null) {
            System.out.println("编号重复，请重新输入！");
            System.out.print("请输入物资编号：");
            goodsID = UIUtils.sc.nextInt();
        }

        System.out.print("请输入物资名称：");
        goodsName = UIUtils.sc.next();
        System.out.print("请输入规格型号：");
        version = UIUtils.sc.next();
        System.out.print("请输入类别：");
        type = UIUtils.sc.next();
        System.out.print("请输入计量单位：");
        unit = UIUtils.sc.next();

        return new goods(goodsID, goodsName, version, type, unit);
    }

    private log_goodsIn putInGoodsInstance(goods s) {
        int amount, houseID, inPutManager, operator;
        double unitPrice, figure;
        String inPutTime = null;
        String remarks;

        System.out.print("请输入数量：");
        amount = UIUtils.sc.nextInt();
        System.out.print("请输入单价：");
        unitPrice = UIUtils.sc.nextDouble();
        System.out.print("请输入金额：");
        figure = UIUtils.sc.nextDouble();

        System.out.print("请输入入库时间（yyyy-MM-dd）：");
        inPutTime = UIUtils.sc.next();

        System.out.print("请输入入库人ID：");
        inPutManager = UIUtils.sc.nextInt();
        System.out.print("请输入经办人ID：");
        operator = UIUtils.sc.nextInt();
        System.out.print("请输入仓库ID：");
        houseID = UIUtils.sc.nextInt();
        System.out.print("请输入备注：");
        remarks = UIUtils.sc.next();

        return new log_goodsIn(s.getGoodsID(), s.getGoodsName(), s.getVersion(), s.getType(), s.getUnit(), amount, unitPrice, figure, inPutTime, inPutManager, operator, houseID, remarks);
    }

    private log_goodsOut putOutGoodsInstance(goods s) {
        int amount, houseID, outPutManager, operator;
        double unitPrice, figure;
        String outPutTime = null;
        String remarks;

        System.out.print("请输入数量：");
        amount = UIUtils.sc.nextInt();
        System.out.print("请输入单价：");
        unitPrice = UIUtils.sc.nextDouble();
        System.out.print("请输入金额：");
        figure = UIUtils.sc.nextDouble();

        System.out.print("请输入出库时间（yyyy-MM-dd）：");
        outPutTime = UIUtils.sc.next();

        System.out.print("请输入出库人ID：");
        outPutManager = UIUtils.sc.nextInt();
        System.out.print("请输入经办人ID：");
        operator = UIUtils.sc.nextInt();
        System.out.print("请输入仓库ID：");
        houseID = UIUtils.sc.nextInt();
        System.out.print("请输入备注：");
        remarks = UIUtils.sc.next();

        return new log_goodsOut(s.getGoodsID(), s.getGoodsName(), s.getVersion(), s.getType(), s.getUnit(), amount, unitPrice, figure, outPutTime, outPutManager, operator, houseID, remarks);
    }
}
