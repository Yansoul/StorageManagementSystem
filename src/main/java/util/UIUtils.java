package util;

import com.sun.jdi.connect.spi.Connection;

import java.util.Scanner;

/**
 * @author Yansoul
 * @date 2021/12/28 - 15:09
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class UIUtils {
    public static Scanner sc = new Scanner(System.in);

    public static void homePageUI() {
        System.out.println("\n\n\n**********库存管理系统**********");
        System.out.println("1. 仓库管理");
        System.out.println("2. 物资管理");
        System.out.println("3. 人员管理");
        System.out.println("4. 退出");
        System.out.print("请选择：");
    }

    public static int makeRightChoice(int left, int right) {
        int choice = sc.nextInt();
        while (choice < left || choice > right) {
            System.out.println("选择范围：" + left + "~" + right + "，请重选！");
            choice = sc.nextInt();
        }
        return choice;
    }

    public static void managerChoose() {
        System.out.println("\n\n\n**********人员管理模块**********");
        System.out.println("1. 插入人员信息");
        System.out.println("2. 删除人员信息");
        System.out.println("3. 修改人员信息");
        System.out.println("4. 查询人员信息");
        System.out.println("5. 返回");
        System.out.print("请选择：");
    }

    public static void warehouseChoose(){
        System.out.println("\n\n\n**********仓库管理模块**********");
        System.out.println("1. 插入仓库信息");
        System.out.println("2. 删除仓库信息");
        System.out.println("3. 修改仓库信息");
        System.out.println("4. 查询仓库信息");
        System.out.println("5. 返回");
        System.out.print("请选择：");
    }

    public static void goodsChoose() {
        System.out.println("\n\n\n**********物资管理模块**********");
        System.out.println("1. 物资入库");
        System.out.println("2. 物资出库");
        System.out.println("3. 查看所有在库物资");
        System.out.println("4. 查询入库日志");
        System.out.println("5. 查询出库日志");
        System.out.println("6. 返回");
        System.out.print("请选择：");
    }
}
