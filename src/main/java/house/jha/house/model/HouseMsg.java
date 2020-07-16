package house.jha.house.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("房屋信息")
public class HouseMsg {


    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHcode() {
        return hcode;
    }

    public void setHcode(String hcode) {
        this.hcode = hcode;
    }

    public HouseType getHouseType() {
        return tid;
    }

    public void setHouseType(HouseType tid) {
        this.tid = tid;
    }

    public int getHsize() {
        return hsize;
    }

    public void setHsize(int hsize) {
        this.hsize = hsize;
    }

    public int getHprice() {
        return hprice;
    }

    public void setHprice(int hprice) {
        this.hprice = hprice;
    }

    public String getHarea() {
        return harea;
    }

    public void setHarea(String harea) {
        this.harea = harea;
    }

    public HouseUser getHouseUser() {
        return userid;
    }

    public void setHouseUser(HouseUser houseUser) {
        this.userid = houseUser;
    }

    public HouseMsg(int hid, String hcode, HouseType tid, int hsize, int hprice, String harea, HouseUser userid) {
        super();
        this.hid = hid;
        this.hcode = hcode;
        this.tid = tid;
        this.hsize = hsize;
        this.hprice = hprice;
        this.harea = harea;
        this.userid = userid;
    }

    @ApiModelProperty("房屋id")
    private int hid;
    @ApiModelProperty("房屋编号")
    private String hcode;
    @ApiModelProperty("房屋类型")
    private HouseType tid;
    @ApiModelProperty("房屋面积")
    private int hsize;
    @ApiModelProperty("房屋价格")
    private int hprice;
    @ApiModelProperty("房屋地段")
    private String harea;
    @ApiModelProperty("房屋主人")
    private HouseUser userid;

    public HouseMsg() {
    }
}
