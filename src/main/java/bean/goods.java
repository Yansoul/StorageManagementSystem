package bean;

/**
 * @author Yansoul
 * @date 2021/12/28 - 11:06
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class goods {
    private int goodsID;
    private String goodsName;
    private String version;
    private String type;
    private String unit;

    public goods() {
    }

    public goods(int goodsID, String goodsName, String version, String type, String unit) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.version = version;
        this.type = type;
        this.unit = unit;
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

    @Override
    public String toString() {
        return "goods{" +
                "goodsID=" + goodsID +
                ", goodsName='" + goodsName + '\'' +
                ", version='" + version + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
