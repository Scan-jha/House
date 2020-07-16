package house.jha.house.controller;

import house.jha.house.model.HouseMsg;
import house.jha.house.service.IHouseManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "restful")
@Api("aop房屋")
public class RestFulController {
    @Autowired
    private IHouseManager service;

    public IHouseManager getService() {
        return service;
    }

    public void setService(IHouseManager service) {
        this.service = service;
    }

    @ApiOperation("根据房屋id查询")
    @RequestMapping(value = "/house/{hid}", method = RequestMethod.GET)
    public ResponseEntity<HouseMsg> selectHouse(@PathVariable("hid") int hid) {
        try {
            HouseMsg h = new HouseMsg();
            h.setHid(hid);
            this.getService().House(h);
            return ResponseEntity.status(HttpStatus.OK).body(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ApiOperation("查询所有")
    @RequestMapping(value = "/house/list", method = RequestMethod.GET)
    public ResponseEntity<List<HouseMsg>> selectAllHouse(HouseMsg h) {
        try {
            List<HouseMsg> list = this.getService().getHouse(h);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
