package house.jha.house.service;


import house.jha.house.model.HouseUser;

import java.util.List;

public interface IHouserUserManager {
    public List<HouseUser> userLogin(HouseUser hu);
}
