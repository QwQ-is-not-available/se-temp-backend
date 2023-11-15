package com.iothomehero.controller;

import com.iothomehero.mapper.RoutineMapper;
import com.iothomehero.pojo.Result;
//import com.iothomehero.pojo.entity.Device;
import com.iothomehero.pojo.entity.Routine;
//import com.iothomehero.service.RoutineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/routine")
public class RoutineController {

    //@Autowired
    //private RoutineService routineService;

    @Autowired
    private RoutineMapper routineMapper;
    @PostMapping("/add")
    public Result add(@RequestBody Routine routine){
        routineMapper.add_routine(routine);
        log.info("user:{} :add routine",routine.getUserId());
        log.info("routine id:"+routine.getId());
        return Result.success(routine.getId());
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        Integer res = routineMapper.delete_routine(id);
        log.info("number:"+res);
        if(res==1){
            return Result.success();
        }else{
            return Result.error();
        }
    }
    @GetMapping("/get_all_routine/{userId}")
    public Result get_all_routine(@PathVariable String userId) {
        List<Routine> routineList = routineMapper.get_all_routine(userId);
        return Result.success(routineList);
    }
    @PutMapping("/rename_routine")
    public Result rename_routine(@RequestBody Routine routine) {
        log.info("To change the name of the routine:{}",routine.getName());
        Integer res = routineMapper.rename_routine(routine);
        return Result.success(routine.getName());
    }

}
