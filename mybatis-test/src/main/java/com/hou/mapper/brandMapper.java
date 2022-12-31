package com.hou.mapper;

import com.hou.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface brandMapper {
    List<Brand> selectAll();
    List<Brand> selectByid(int id);
    //注解方法
    List<Brand> selectaa(@Param("companyName") String companyName ,@Param("brandName") String brandName,@Param("status") Integer status);
    //map方法
    List<Brand> selectChose(Map map);
    //构造方法
    List<Brand> selectChoice(Brand brand);

    List<Brand> selectConditionByChoice(@Param("companyName") String companyName, @Param("brandName") String brandName);

    void addOne(Brand brand);

}
