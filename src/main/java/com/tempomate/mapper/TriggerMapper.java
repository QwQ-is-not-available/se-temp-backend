package com.tempomate.mapper;

import com.tempomate.pojo.entity.Routine;
import com.tempomate.pojo.entity.trigger.TriAssistant;
import com.tempomate.pojo.entity.trigger.TriLocation;
import com.tempomate.pojo.entity.trigger.TriPosture;
import com.tempomate.pojo.entity.trigger.TriTime;
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
    @Insert("insert into tri_posture(mode, left_top_x, left_top_y, right_bottom_x, right_bottom_y, ip) values (#{mode},#{leftTopX},#{leftTopY},#{rightBottomX},#{rightBottomY},#{ip});")
    public void triPostureAdd(TriPosture triPosture);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into tri_assistant(command) values (#{command})")
    public void triAssistantAdd(TriAssistant triAssistant);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into tri_time(time) values (#{time});")
    public void triTimeAdd(TriTime triTime);

    //get
    @Select("select id, mode, longitude, latitude from tri_location where id=#{triggerId};")
    public TriLocation getTriLocation(Routine routine);

    @Select("select id, mode, left_top_x, left_top_y, right_bottom_x, right_bottom_y, ip from tri_posture where id=#{triggerId};")
    public TriPosture getTriPosture(Routine routine);

    @Select("select id, command from tri_assistant where id=#{triggerId}")
    public TriAssistant getTriAssistant(Routine routine);

    @Select("select id, time from tri_time where id=#{triggerId};")
    public TriTime getTriTime(Routine routine);

}
