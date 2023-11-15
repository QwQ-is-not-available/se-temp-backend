package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.Routine;
import com.iothomehero.pojo.entity.trigger.TriAssistant;
import com.iothomehero.pojo.entity.trigger.TriLocation;
import com.iothomehero.pojo.entity.trigger.TriPosture;
import com.iothomehero.pojo.entity.trigger.TriTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TriggerMapper {

    //add
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_location(mode, longitude, latitude) VALUES (#{mode},#{longitude},#{latitude})")
    public void triLocationAdd(TriLocation triLocation);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into tri_posture(mode, coordinate_x, coordinate_y, ip) values (#{mode},#{coordinateX},#{coordinateY},#{ip});")
    public void triPostureAdd(TriPosture triPosture);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into tri_assistant(command) values (#{command})")
    public void triAssistantAdd(TriAssistant triAssistant);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into tri_time(time) values (#{time});")
    public void triTimeAdd(TriTime triTime);

    //get
    @Select("select id, mode, longitude, latitude from tri_location where id=#{trigger_id};")
    public TriLocation getTriLocation(Routine routine);

    @Select("select id, mode, coordinate_x, coordinate_y, ip from tri_posture where id=#{trigger_id};")
    public TriPosture getTriPosture(Routine routine);

    @Select("select id, command from tri_assistant where id=#{trigger_id}")
    public TriAssistant getTriAssistant(Routine routine);

    @Select("select id, time from tri_time where id=#{trigger_id};")
    public TriTime getTriTime(Routine routine);

}
