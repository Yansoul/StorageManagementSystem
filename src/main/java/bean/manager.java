package bean;

/**
 * @author Yansoul
 * @date 2021/12/28 - 11:06
 * 人生到处知何似，应似飞鸿踏雪泥
 */
public class manager {
    private int managerID;
    private String managerName;
    private String managerCall;

    public manager() {
    }

    public manager(int managerID, String managerName, String managerCall) {
        this.managerID = managerID;
        this.managerName = managerName;
        this.managerCall = managerCall;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerCall() {
        return managerCall;
    }

    public void setManagerCall(String managerCall) {
        this.managerCall = managerCall;
    }

    @Override
    public String toString() {
        return "manager{" +
                "managerID=" + managerID +
                ", managerName='" + managerName + '\'' +
                ", managerCall='" + managerCall + '\'' +
                '}';
    }
}
