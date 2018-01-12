package com.lxy.demo.user;

import com.lxy.demo.user.mapper.MerchantUserEntityDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MerchantUserEntityService {

    @Resource
    private MerchantUserEntityDao merchantUserEntityDao;

    public int insert(MerchantUserEntity pojo){
        return merchantUserEntityDao.insert(pojo);
    }

    public int insertList(List< MerchantUserEntity> pojos){
        return merchantUserEntityDao.insertList(pojos);
    }

    public List<MerchantUserEntity> select(MerchantUserEntity pojo){
        return merchantUserEntityDao.select(pojo);
    }

    public int update(MerchantUserEntity pojo){
        return merchantUserEntityDao.update(pojo);
    }

}
