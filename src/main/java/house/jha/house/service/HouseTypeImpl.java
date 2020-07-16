package house.jha.house.service;

import house.jha.house.mapper.HouseUserMapper;
import house.jha.house.model.HouseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseTypeImpl implements IHouseTypeManager {
    @Autowired
    private HouseUserMapper mapper;

    public HouseUserMapper getMapper() {
        return mapper;
    }

    public void setMapper(HouseUserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<HouseType> houseType() {
        return this.getMapper().allHouseType();
    }
}
