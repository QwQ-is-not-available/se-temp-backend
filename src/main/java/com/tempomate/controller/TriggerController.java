package com.tempomate.controller;

import com.tempomate.mapper.TriggerMapper;
import com.tempomate.pojo.Result;
import com.tempomate.pojo.entity.Routine;
import com.tempomate.pojo.entity.trigger.TriAssistant;
import com.tempomate.pojo.entity.trigger.TriLocation;
import com.tempomate.pojo.entity.trigger.TriPosture;
import com.tempomate.pojo.entity.trigger.TriTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/trigger")
public class TriggerController {

    @Autowired
    private TriggerMapper triggerMapper;

    @PostMapping("/loc_add")
    public Result addTriLocation(@RequestBody TriLocation triLocation){
        triggerMapper.triLocationAdd(triLocation);
        log.info("add a location trigger:"+triLocation.getId());
        return Result.success(triLocation.getId());
    }

    @PostMapping("/pos_add")
    public Result addTriPosture(@RequestBody TriPosture triPosture){
        triggerMapper.triPostureAdd(triPosture);
        log.info("add a posture trigger:"+triPosture.getId());
        return Result.success(triPosture.getId());
    }

    @PostMapping("/assi_add")
    public Result addTriAssistant(@RequestBody TriAssistant triAssistant){
        triggerMapper.triAssistantAdd(triAssistant);
        log.info("add a assistant trigger:"+triAssistant.getId());
        return Result.success(triAssistant.getId());
    }

    @PostMapping("/time_add")
    public Result addTriTime(@RequestBody TriTime triTime){
        triggerMapper.triTimeAdd(triTime);
        log.info("add a time trigger:"+triTime.getId());
        return Result.success(triTime.getId());
    }

    @PostMapping("/get")
    public Result getTrigger(@RequestBody Routine routine){
        // just need triggerType and triggerId in routine
        switch(routine.getTriggerType()){
            case 1:
                TriLocation triLocation = triggerMapper.getTriLocation(routine);
                if(triLocation!=null){
                    return Result.success(triLocation);
                }else {
                    return Result.error("no match");
                }
            case 2:
                TriPosture triPosture = triggerMapper.getTriPosture(routine);
                if(triPosture!=null){
                    return Result.success(triPosture);
                }else {
                    return Result.error("no match");
                }
            case 3:
                TriAssistant triAssistant = triggerMapper.getTriAssistant(routine);
                if(triAssistant!=null){
                    return Result.success(triAssistant);
                }else {
                    return Result.error("no match");
                }
            case 4:
                TriTime triTime = triggerMapper.getTriTime(routine);
                if(triTime!=null){
                    return Result.success(triTime);
                }else {
                    return Result.error("no match");
                }
            default:
                return Result.error("no match");
        }
        //return Result.success();
    }



}
