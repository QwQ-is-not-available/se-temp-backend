package com.iothomehero.controller;

import com.iothomehero.mapper.TriggerMapper;
import com.iothomehero.pojo.Result;
import com.iothomehero.pojo.entity.trigger.TriLocation;
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

}
