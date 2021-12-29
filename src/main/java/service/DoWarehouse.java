package service;

import DAO.warehouseDAOImpl;
import bean.warehouse;
import util.UIUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 14:56
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class DoWarehouse {
    Connection conn;

    DoWarehouse(Connection conn) {
        this.conn = conn;
        UIUtils.warehouseChoose();
    }

    public void choose() {
        warehouseDAOImpl operate = new warehouseDAOImpl();
        boolean flag = true;
        int choiceWH;
        while (flag) {
            UIUtils.warehouseChoose();
            choiceWH = UIUtils.makeRightChoice(1, 5);
            switch (choiceWH) {
                case 1:
                    warehouse toInsert = this.WarehouseInstance();
                    operate.insert(conn, toInsert);
                    System.out.println("插入成功");
                    break;
                case 2:
                    System.out.println("请输入要删除的ID：");
                    int id = UIUtils.sc.nextInt();
                    operate.deleteById(conn, id);
                    System.out.println("删除成功");
                    break;
                case 3:
                    System.out.println("请输入要修改的ID：");
                    int id2 = UIUtils.sc.nextInt();
                    warehouse toUpdate = operate.getWarehouseById(conn, id2);
                    operate.update(conn, toUpdate);
                    System.out.println("修改成功");
                    break;
                case 4:
                    System.out.println("要查询：1.单个数据 2.全部数据");
                    int ch = UIUtils.makeRightChoice(1, 2);
                    if (ch == 1) {
                        System.out.print("请输入要查询的ID：");
                        int id3 = UIUtils.sc.nextInt();
                        warehouse wh = operate.getWarehouseById(conn, id3);
                        if(wh != null)
                            System.out.println(wh.toString());
                        else
                            System.out.println("未查到指定数据！");
                    } else {
                        List<warehouse> list = operate.getAll(conn);
                        if(list != null) {
                            for (warehouse w : list)
                                System.out.println(w.toString());
                        }
                        else
                            System.out.println("数据表为空！");
                    }
                    break;
                case 5:
                    flag = false;
                    System.out.println("返回成功");
            }
        }
    }

    private warehouse WarehouseInstance() {
        warehouseDAOImpl operate = new warehouseDAOImpl();

        int houseID;
        String houseName, chargeName, Call, addr;

        System.out.print("请输入仓库编号：");
        houseID = UIUtils.sc.nextInt();

        while(operate.getWarehouseById(conn, houseID) != null){
            System.out.println("编号重复，请重新输入！");
            System.out.print("请输入仓库编号：");
            houseID = UIUtils.sc.nextInt();
        }


        System.out.print("请输入仓库名称：");
        houseName = UIUtils.sc.next();
        System.out.print("请输入负责人：");
        chargeName = UIUtils.sc.next();
        System.out.print("请输入联系电话：");
        Call = UIUtils.sc.next();
        System.out.print("请输入仓库地址：");
        addr = UIUtils.sc.next();
        return new warehouse(houseID, houseName, chargeName, Call, addr);
    }
}
