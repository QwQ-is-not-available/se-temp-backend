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

    @PutMapping("/rename_device/{id}")
    public Result rename_device(@PathVariable Integer id, @RequestBody Device device) {
        log.info("To change the name of the device:{}",device.getName());
        Integer res = deviceMapper.rename_device(id, device.getName());
        return Result.success(device.getName());
    }

   /* @GetMapping("/status/{id}")
    public Result switch_status(@PathVariable Integer id) {
        return Result.success(deviceMapper.switch_status(id));
    }*/

    @PutMapping("/change_status/{id}")
    public Result change_status(@PathVariable Integer id, @RequestBody Device device) {
        if (device.getSwitchStatus() >=0 && device.getSwitchStatus() <= 100) {
            log.info("To change the switch status:{}", device.getSwitchStatus());
            Integer res = deviceMapper.change_status(id, device.getSwitchStatus());
            return Result.success(device.getSwitchStatus());
        }
        else {
            log.error("Wrong input for switch status:{}", device.getSwitchStatus());
            return Result.error("Wrong input");
        }
    }
}
