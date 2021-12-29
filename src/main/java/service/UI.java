package service;

import util.JDBCUtils;
import util.UIUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Yansoul
 * @date 2021/12/28 - 14:46
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class UI {
    public void homePage(Connection conn) {
        int choice;

        boolean flag = true;
        while(flag){
            UIUtils.homePageUI();
            choice = UIUtils.makeRightChoice(1,4);
            switch(choice){
                case 1:
                    DoWarehouse dw = new DoWarehouse(conn);
                    dw.choose();
                    break;
                case 2:
                    DoGoods dg = new DoGoods(conn);
                    dg.choose();
                    break;
                case 3:
                    DoManager dm = new DoManager(conn);
                    dm.choose();
                    break;
                case 4:
                    flag = false;
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            new UI().homePage(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
