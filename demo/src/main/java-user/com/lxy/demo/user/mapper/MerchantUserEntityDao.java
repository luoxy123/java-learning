package com.lxy.demo.user.mapper;

import com.lxy.demo.user.MerchantUserDto;
import com.lxy.demo.user.MerchantUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

   public interface MerchantUserEntityDao {

    int insert(@Param("pojo") MerchantUserEntity pojo);

    int insertList(@Param("pojos") List<MerchantUserEntity> pojos);

    List<MerchantUserEntity> select(@Param("pojo") MerchantUserEntity pojo);

    int update(@Param("pojo") MerchantUserEntity pojo);


    List<MerchantUserDto> selectall(@Param("pojo") MerchantUserEntity pojo);


}