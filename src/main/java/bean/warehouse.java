package bean;

/**
 * @author Yansoul
 * @date 2021/12/28 - 11:06
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class warehouse {
    private int HouseID;
    private String HouseName;
    private String ChargeName;
    private String Call;
    private String Addr;

    public warehouse(int houseID, String houseName, String chargeName, String call, String addr) {
        this.HouseID = houseID;
        this.HouseName = houseName;
        this.ChargeName = chargeName;
        this.Call = call;
        this.Addr = addr;
    }

    public warehouse() {
    }

    public int getHouseID() {
        return HouseID;
    }

    public void setHouseID(int houseID) {
        this.HouseID = houseID;
    }

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        this.HouseName = houseName;
    }

    public String getChargeName() {
        return ChargeName;
    }

    public void setChargeName(String chargeName) {
        this.ChargeName = chargeName;
    }

    public String getCall() {
        return Call;
    }

    public void setCall(String call) {
        this.Call = call;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        this.Addr = addr;
    }

    @Override
    public String toString() {
        return "warehouse{" +
                "houseID=" + HouseID +
                ", houseName='" + HouseName + '\'' +
                ", chargeName='" + ChargeName + '\'' +
                ", call='" + Call + '\'' +
                ", addr='" + Addr + '\'' +
                '}';
    }
}
