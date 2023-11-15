package com.iothomehero.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Routine {
    private Integer id;
    private String userId;
    private String name;
    private Short onOff;
    private Short triggerType;
    private Integer triggerId;
}
