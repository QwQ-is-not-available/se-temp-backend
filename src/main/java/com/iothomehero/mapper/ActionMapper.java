package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.action.ActDevice;
import com.iothomehero.pojo.entity.action.ActTime;
import com.iothomehero.pojo.entity.action.Action;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ActionMapper {

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into action(routine_id, action_type, action_id) VALUES (#{routineId},#{actionType},#{actionId});")
    public void addAction(Action action);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into act_device(device_id, switch_status, text) VALUES (#{deviceId},#{switchStatus},#{text});")
    public void addActDevice(ActDevice actDevice);

    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into act_time(time) values (#{time});")
    public void addActTime(ActTime actTime);



}
