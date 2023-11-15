package com.iothomehero.controller;

import com.iothomehero.mapper.ActionMapper;
import com.iothomehero.pojo.Result;
import com.iothomehero.pojo.entity.action.ActDevice;
import com.iothomehero.pojo.entity.action.ActTime;
import com.iothomehero.pojo.entity.action.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/action")
public class ActionController {
    @Autowired
    private ActionMapper actionMapper;

    @PostMapping("/actDevice_add")
    public Result addActDevice(@RequestBody ActDevice actDevice){
        actionMapper.addActDevice(actDevice);
        actionMapper.addAction(new Action(null,actDevice.getRoutineId(), (short) 1,actDevice.getId()));
        log.info("action device added id:"+actDevice.getId());
        return Result.success(actDevice.getId());
    }

    @PostMapping("/actTime_add")
    public Result addActTime(@RequestBody ActTime actTime){
        actionMapper.addActTime(actTime);
        actionMapper.addAction(new Action(null, actTime.getRoutineId(), (short)2,actTime.getId()));
        log.info("action time added id:"+actTime.getId());
        return Result.success(actTime.getId());
    }


}
