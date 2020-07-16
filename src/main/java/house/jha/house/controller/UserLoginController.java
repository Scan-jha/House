package house.jha.house.controller;

import house.jha.house.model.HouseUser;
import house.jha.house.service.IHouserUserManager;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@Api("登录接口")
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private IHouserUserManager service;

    public IHouserUserManager getService() {
        return service;
    }

    public void setService(IHouserUserManager service) {
        this.service = service;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation("登录")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = HouseUser.class)})
    public HashMap<String, Object> isLogin(@ApiParam("姓名") @RequestParam("usercode") String name,
                                           @ApiParam("密码") @RequestParam("userpwd") String pwd) {

        HouseUser u = new HouseUser();
        u.setUsercode(name);
        u.setUserpwd(pwd);
        List<HouseUser> l = this.getService().userLogin(u);

        HashMap<String, Object> hm = new HashMap<>();
        if (l.size() > 0) {
            hm.put("statecode", 200);
            hm.put("desc", "成功");
            hm.put("list", l);
        } else {
            hm.put("statecode", 201);
            hm.put("desc", "用户名和密码错误");
        }
        return hm;
    }
}
