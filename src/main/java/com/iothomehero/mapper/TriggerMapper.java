package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.trigger.TriLocation;
import com.iothomehero.pojo.entity.trigger.TriPosture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TriggerMapper {

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_location(mode, longitude, latitude) VALUES (#{mode},#{longitude},#{latitude})")
    public void triLocationAdd(TriLocation triLocation);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_posture(mode, coordinate_x, coordinate_y, ip) values (#{mode},#{coX},#{coY},#{ip});")
    public void triPostureAdd(TriPosture triPosture);


}
