package com.tempomate.service.impl;

import com.tempomate.mapper.DeviceMapper;
import com.tempomate.pojo.entity.Device;
import com.tempomate.service.DeviceService;
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
