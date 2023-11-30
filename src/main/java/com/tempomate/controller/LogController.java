package com.tempomate.controller;

import com.tempomate.mapper.LogMapper;
import com.tempomate.pojo.Result;
import com.tempomate.pojo.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogMapper logMapper;
    @GetMapping("/user/{userId}")
    public Result get_all_log(@PathVariable String userId){
        List<Log> logList = logMapper.get_all_log(userId);
        return Result.success(logList);
    }
}
