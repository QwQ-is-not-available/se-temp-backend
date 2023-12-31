package com.tempomate.controller;

import com.tempomate.mapper.ActionMapper;
import com.tempomate.pojo.Result;
import com.tempomate.pojo.entity.action.ActDevice;
import com.tempomate.pojo.entity.action.ActTime;
import com.tempomate.pojo.entity.action.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/get_all_action/{userId}")
    public Result get_all_action(@PathVariable String userId, @RequestBody Action action) {
        List<ActDevice> actDeviceList = actionMapper.getActDevice(userId, action.getRoutineId());
        List<ActTime> actTimeList = actionMapper.getActTime(userId, action.getRoutineId());
        log.info("Action list for user_id: " + userId);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("actDevices", actDeviceList);
        resultMap.put("actTimes", actTimeList);
        return Result.success(resultMap);
    }

    @DeleteMapping("/delete")
    public Result deleteAction(@RequestBody Action action){
        log.info("delete actionType:{}, actionId:{}",action.getActionType(),action.getActionId());
        Integer res = actionMapper.deleteAction(action);
        if(res==0){
            return Result.error("no match");
        }
        switch (action.getActionType()){
            case 1:
                actionMapper.deleteActDevice(action);
                return Result.success();
            case 2:
                actionMapper.deleteActTime(action);
                return Result.success();
            default:
                return Result.error("no match");
        }
    }

}
