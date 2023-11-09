package com.iothomehero.controller;

import com.iothomehero.mapper.DeviceMapper;
import com.iothomehero.pojo.Result;
import com.iothomehero.pojo.entity.Device;
import com.iothomehero.service.DeviceService;
import com.iothomehero.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/device")
public class DeviceController {

//    @Autowired
//    private DeviceService deviceService;

    @Autowired
    private DeviceMapper deviceMapper;

    @PostMapping("/add")
    public Result add(@RequestBody Device device){
//        deviceService.add(device);
        deviceMapper.add_device(device);
        log.info("user:{} :add device",device.getUserId());
        log.info("device id:"+device.getId());
        return Result.success(device.getId());
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Integer res = deviceMapper.delete_device(id);
        log.info("number:"+res);
        if(res==1){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    @GetMapping("/get_all_device/{userId}")
    public Result get_all_device(@PathVariable String userId){
        List<Device> deviceList = deviceMapper.get_all_device(userId);
        return Result.success(deviceList);
    }

}
