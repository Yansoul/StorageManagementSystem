package service;

import DAO.managerDAOImpl;
import bean.manager;
import bean.warehouse;
import util.UIUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Yansoul
 * @date 2021/12/28 - 14:57
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class DoManager {
    Connection conn;

    DoManager(Connection conn) {
        this.conn = conn;
        UIUtils.managerChoose();
    }

    public void choose() {
        managerDAOImpl operate = new managerDAOImpl();
        boolean flag = true;
        int choiceM;
        while (flag) {
            UIUtils.managerChoose();
            choiceM = UIUtils.makeRightChoice(1, 5);
            switch (choiceM) {
                case 1:
                    manager toInsert = this.managerInstance();
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
                    manager toUpdate = operate.getManagerById(conn, id2);
                    operate.update(conn, toUpdate);
                    System.out.println("修改成功");
                    break;
                case 4:
                    System.out.println("要查询：1.单个数据 2.全部数据");
                    int ch = UIUtils.makeRightChoice(1, 2);
                    if (ch == 1) {
                        System.out.print("请输入要查询的ID：");
                        int id3 = UIUtils.sc.nextInt();
                        manager wh = operate.getManagerById(conn, id3);
                        if (wh != null)
                            System.out.println(wh.toString());
                        else
                            System.out.println("未查到指定数据！");
                    } else {
                        List<manager> list = operate.getAll(conn);
                        if (list != null && list != null && list.size() != 0) {
                            for (manager w : list)
                                System.out.println(w.toString());
                        } else
                            System.out.println("数据表为空！");
                    }
                    break;
                case 5:
                    flag = false;
                    System.out.println("返回成功");
            }
        }
    }

    private manager managerInstance() {
        managerDAOImpl operate = new managerDAOImpl();
        int managerID;
        String managerName, managerCall;

        System.out.print("请输入人员编号：");
        managerID = UIUtils.sc.nextInt();

        while (operate.getManagerById(conn, managerID) != null) {
            System.out.println("编号重复，请重新输入！");
            System.out.print("请输入仓库编号：");
            managerID = UIUtils.sc.nextInt();
        }

        System.out.print("请输入人员姓名：");
        managerName = UIUtils.sc.next();
        System.out.print("请输入人员电话：");
        managerCall = UIUtils.sc.next();
        return new manager(managerID, managerName, managerCall);
    }
}
