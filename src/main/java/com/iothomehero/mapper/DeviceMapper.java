package com.iothomehero.mapper;

import com.iothomehero.pojo.entity.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface DeviceMapper {
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into device(name, type, user_id, switch_status, text) " +
            "values(#{name},#{type},#{userId},#{switchStatus},#{text});")
    public void add_device(Device device);

    @Select("select id, name, type, user_id, switch_status, text " +
            "from device where user_id=#{userId};")
    public List<Device> get_all_device(String userId);

    @Delete("delete from device where id=#{id}")
    public Integer delete_device(Integer id);

    @Update("UPDATE device SET name = #{deviceName} WHERE id = #{id}")
    public Integer rename_device(@Param("id") Integer id, @Param("deviceName") String deviceName);

    //@Select("SELECT switch_status FROM device WHERE id = #{id}")
    //Integer switch_status(@Param("id") Integer id);

    @Update("UPDATE device SET switch_status = #{switchStatus} WHERE id = #{id}")
    public Integer change_status(@Param("id") Integer id, @Param("switchStatus") Short switchStatus);

}
