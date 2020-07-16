package house.jha.house.service;

import com.github.pagehelper.PageInfo;
import house.jha.house.model.HouseMsg;

import java.util.List;

public interface IHouseManager {
    public boolean addHouse(HouseMsg hm);

    public List<HouseMsg> allHouses();

    public boolean deleteHouse(HouseMsg hm);

    //restful
    public List<HouseMsg> House(HouseMsg h);

    public List<HouseMsg> getHouse(HouseMsg h);

    //分页
    public PageInfo<HouseMsg> getEmpsFY(int currentpage, int pagesize);
}
