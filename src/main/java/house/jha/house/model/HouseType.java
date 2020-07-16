package house.jha.house.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("房屋类型")
public class HouseType {

    @ApiModelProperty("房屋编号")
    private int tid;

    public HouseType() {
    }

    public HouseType(int tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    @ApiModelProperty("房屋类型")
    private String tname;


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

}
