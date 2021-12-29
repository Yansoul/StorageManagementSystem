package bean;

import java.util.Date;

/**
 * @author Yansoul
 * @date 2021/12/28 - 11:19
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class log_goodsIn {
    private int goodsID;
    private String goodsName;
    private String version;
    private String type;
    private String unit;

    @Override
    public String toString() {
        return "log_goodsIn{" +
                "goodsID=" + goodsID +
                ", goodsName='" + goodsName + '\'' +
                ", version='" + version + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                ", unitPrice=" + unitPrice +
                ", figure=" + figure +
                ", inPutTime='" + inPutTime + '\'' +
                ", inPutManager=" + inPutManager +
                ", operator=" + operator +
                ", houseID=" + houseID +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public log_goodsIn(int goodsID, String goodsName, String version, String type, String unit, int amount, double unitPrice, double figure, String inPutTime, int inPutManager, int operator, int houseID, String remarks) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.version = version;
        this.type = type;
        this.unit = unit;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.figure = figure;
        this.inPutTime = inPutTime;
        this.inPutManager = inPutManager;
        this.operator = operator;
        this.houseID = houseID;
        this.remarks = remarks;
    }

    private int amount;
    private double unitPrice;
    private double figure;
    private String inPutTime;
    private int inPutManager;
    private int operator;
    private int houseID;
    private String remarks;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getFigure() {
        return figure;
    }

    public void setFigure(double figure) {
        this.figure = figure;
    }

    public String getInPutTime() {
        return inPutTime;
    }

    public void setInPutTime(String inPutTime) {
        this.inPutTime = inPutTime;
    }

    public int getInPutManager() {
        return inPutManager;
    }

    public void setInPutManager(int inPutManager) {
        this.inPutManager = inPutManager;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public log_goodsIn(){}
}
