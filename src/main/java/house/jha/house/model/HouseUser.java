package house.jha.house.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")
public class HouseUser {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public HouseUser(int userId, String usercode, String userpwd) {
        super();
        this.userId = userId;
        this.usercode = usercode;
        this.userpwd = userpwd;
    }

    @ApiModelProperty("用户编号")
    private int userId;
    @ApiModelProperty("用户名")
    private String usercode;
    @ApiModelProperty("用户密码")
    private String userpwd;

    public HouseUser() {
    }
}
