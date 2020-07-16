package house.jha.house.controller;

import com.github.pagehelper.PageInfo;
import house.jha.house.model.HouseMsg;
import house.jha.house.model.HouseType;
import house.jha.house.model.HouseUser;
import house.jha.house.service.IHouseManager;
import house.jha.house.service.IHouseTypeManager;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@Api("房屋操作")
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private IHouseTypeManager service;

    public IHouseTypeManager getService() {
        return service;
    }

    public void setService(IHouseTypeManager service) {
        this.service = service;
    }

    @Autowired
    private IHouseManager manager;

    public IHouseManager getManager() {
        return manager;
    }

    public void setManager(IHouseManager manager) {
        this.manager = manager;
    }

    @ApiOperation("房屋类型")
    @RequestMapping(value = "/housetype", method = RequestMethod.GET)
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = HouseType.class)})
    public HashMap<String, Object> houseTypes() {
        HashMap<String, Object> hm = new HashMap<>();
        List<HouseType> l = this.getService().houseType();
        if (l.size() > 0) {
            hm.put("statecode", 200);
            hm.put("desc", "成功");
            hm.put("list", l);
        } else {
            hm.put("statecode", 201);
            hm.put("desc", "失败");
        }
        return hm;
    }

    @ApiOperation("添加房屋")
    @RequestMapping(value = "/addhouse", method = RequestMethod.POST)
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = HouseMsg.class)})
    public String addHouse(@RequestBody HouseMsg hm) {
        this.getManager().addHouse(hm);
        return "ok";
    }


    @ApiOperation("查询房屋")
    @RequestMapping(value = "/allhouse", method = RequestMethod.GET)
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = HouseMsg.class)})
    public HashMap<String, Object> allHouses() {
        HashMap<String, Object> hm = new HashMap<>();
        List<HouseMsg> l = this.getManager().allHouses();
        if (l != null) {
            hm.put("statecode", 200);
            hm.put("desc", "成功");
            hm.put("list", l);
        } else {
            hm.put("statecode", 201);
            hm.put("desc", "失败");
        }
        return hm;
    }

    @ApiOperation("删除房屋")
    @RequestMapping(value = "/deletehouse", method = RequestMethod.GET)
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = HouseMsg.class)})
    public HashMap<String, Object> deleteHouse(@ApiParam("房屋id") @RequestParam("hid") int hid) {
        HashMap<String, Object> hm = new HashMap<>();

        HouseMsg h = new HouseMsg();
        h.setHid(hid);
        boolean isOK = this.getManager().deleteHouse(h);
        if (isOK) {
            hm.put("statecode", 200);
            hm.put("desc", "成功");
        } else {
            hm.put("statecode", 201);
            hm.put("desc", "失败");
        }
        return hm;
    }

    //分页
    @RequestMapping(value = "/housefy", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询房屋信息分页功能")
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = HouseMsg.class)})
    public HashMap<String, Object> getEmpsFY(@ApiParam("当前页") @RequestParam("cruuent") int current,
                                             @ApiParam("每页数据") @RequestParam("psize") int psize) {
        PageInfo<HouseMsg> pinfo = this.getManager().getEmpsFY(current, psize);
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("count", pinfo.getTotal());
        hm.put("data", pinfo.getList());
        return hm;

    }
}
