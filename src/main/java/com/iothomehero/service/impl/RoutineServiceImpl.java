package com.iothomehero.service.impl;

import com.iothomehero.mapper.RoutineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoutineServiceImpl {
    @Autowired
    private RoutineMapper routineMapper;


}
