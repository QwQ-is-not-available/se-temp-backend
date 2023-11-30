package com.tempomate.mapper;

import com.tempomate.pojo.entity.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface LogMapper {
    @Select("select id, user_id, time, routine_id " +
            "from log1 where user_id=#{userId};")
    public List<Log> get_all_log(String userId);
}
