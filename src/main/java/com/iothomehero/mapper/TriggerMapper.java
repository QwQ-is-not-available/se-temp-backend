package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.trigger.TriLocation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TriggerMapper {

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_location(mode, longitude, latitude) VALUES (#{mode},#{longitude},#{latitude})")
    public void triLocationAdd(TriLocation triLocation);
}
