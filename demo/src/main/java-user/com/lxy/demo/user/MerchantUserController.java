package com.lxy.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("merchant/user")
public class MerchantUserController {
    @Autowired
    private MerchantUserEntityService merchantUserEntityDao;

    @RequestMapping("list")
    public List<MerchantUserEntity> selectMerchantUser(MerchantUserEntity entity)
    {
        return merchantUserEntityDao.select(entity);
    }

    @RequestMapping("getname")
    public String getMerchantName(MerchantUserEntity entity)
    {
        return entity.getName();
    }


    @RequestMapping("getall")
    public List<MerchantUserDto> getall(MerchantUserEntity entity)
    {
        return merchantUserEntityDao.selectall(entity);
    }

}
