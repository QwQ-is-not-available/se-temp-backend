package com.iothomehero.service.impl;

import com.iothomehero.mapper.DeviceMapper;
import com.iothomehero.pojo.entity.Device;
import com.iothomehero.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {
//not in use
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public void add(Device device) {
        deviceMapper.add_device(device);
    }
}
