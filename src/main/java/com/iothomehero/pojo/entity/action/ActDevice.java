package com.iothomehero.pojo.entity.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActDevice {
    private Integer id;
    private Integer routineId;
    private Integer deviceId;
    private Short switchStatus;
    private String text;
}