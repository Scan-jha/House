package house.jha.house.mapper;

import house.jha.house.model.HouseMsg;
import house.jha.house.model.HouseType;
import house.jha.house.model.HouseUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseUserMapper {
    //登录
    public List<HouseUser> allHouseUser(HouseUser hu);

    //查询房屋类型
    public List<HouseType> allHouseType();

    //添加房屋
    public boolean addHouse(HouseMsg hm);

    //查询所有房屋
    public List<HouseMsg> allHouse();

    //删除房屋
    public boolean deleteHouse(HouseMsg hm);

    //restful
    public List<HouseMsg> House(HouseMsg h);

    public List<HouseMsg> getHouse(HouseMsg h);

}
