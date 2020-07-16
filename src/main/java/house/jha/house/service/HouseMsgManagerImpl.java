package house.jha.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import house.jha.house.mapper.HouseUserMapper;
import house.jha.house.model.HouseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseMsgManagerImpl implements IHouseManager {
    @Autowired
    private HouseUserMapper mapper;

    public HouseUserMapper getMapper() {
        return mapper;
    }

    public void setMapper(HouseUserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean addHouse(HouseMsg hm) {
        return this.getMapper().addHouse(hm);
    }

    @Override
    public List<HouseMsg> allHouses() {
        return this.getMapper().allHouse();
    }

    @Override
    public boolean deleteHouse(HouseMsg hm) {
        return this.getMapper().deleteHouse(hm);
    }

    @Override
    public List<HouseMsg> House(HouseMsg h) {
        return this.getMapper().House(h);
    }

    @Override
    public List<HouseMsg> getHouse(HouseMsg h) {
        return this.getMapper().getHouse(h);
    }

    /**
     * 分页方法
     * @param currentpage
     * @param pagesize
     * @return
     */
    @Override
    public PageInfo<HouseMsg> getEmpsFY(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage, pagesize);
        List<HouseMsg> l = this.getMapper().allHouse();
        PageInfo<HouseMsg> p = new PageInfo<>(l);
        return p;
    }
}
