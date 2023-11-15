package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.Routine;
import com.iothomehero.pojo.entity.trigger.TriAssistant;
import com.iothomehero.pojo.entity.trigger.TriLocation;
import com.iothomehero.pojo.entity.trigger.TriPosture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TriggerMapper {

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_location(mode, longitude, latitude) VALUES (#{mode},#{longitude},#{latitude})")
    public void triLocationAdd(TriLocation triLocation);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_posture(mode, coordinate_x, coordinate_y, ip) values (#{mode},#{coordinateX},#{coordinateY},#{ip});")
    public void triPostureAdd(TriPosture triPosture);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into tri_assistant(command) values (#{command})")
    public void triAssistantAdd(TriAssistant triAssistant);

    @Select("select id, mode, longitude, latitude from tri_location where id=#{triggerId};")
    public TriLocation getTriLocation(Routine routine);

    @Select("select id, mode, coordinate_x, coordinate_y, ip from tri_posture where id=#{triggerId};")
    public TriPosture getTriPosture(Routine routine);

    @Select("select id, command from tri_assistant where id=#{triggerId}")
    public TriAssistant getTriAssistant(Routine routine);

}
