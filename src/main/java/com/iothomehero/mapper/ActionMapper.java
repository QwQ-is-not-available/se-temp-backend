package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.action.ActDevice;
import com.iothomehero.pojo.entity.action.ActTime;
import com.iothomehero.pojo.entity.action.Action;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Select("SELECT * FROM act_device WHERE id IN (SELECT action_id FROM action WHERE routine_id IN (SELECT id FROM routine WHERE user_id = #{userId}) AND action_type = 1)")
    List<ActDevice> getActDevice(@Param("userId") String userId, @Param("routineId") Integer routineId);

    @Select("SELECT * FROM act_time WHERE id IN (SELECT action_id FROM action WHERE routine_id IN (SELECT id FROM routine WHERE user_id = #{userId}) AND action_type = 2)")
    List<ActTime> getActTime(@Param("userId") String userId, @Param("routineId") Integer routineId);

}
