package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.Device;
import com.iothomehero.pojo.entity.Routine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoutineMapper {
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into routine(user_id, name, trigger_type, trigger_id) " +
            "values(#{userId},#{name},#{triggerType},#{triggerId});")
    public void add_routine(Routine routine);
    @Delete("delete from routine where id=#{id}")
    public Integer delete_routine(Integer id);
    @Select("select id, user_id, name, on_off, trigger_type, trigger_id " +
            "from routine where user_id=#{userId};")
    public List<Routine> get_all_routine(String userId);
    @Update("UPDATE routine SET name = #{name} WHERE id = #{id}")
    public Integer rename_routine(Routine routine);
    @Update("UPDATE routine SET on_off = #{onOff} WHERE id = #{id}")
    public Integer change_status(Routine routine);
}
