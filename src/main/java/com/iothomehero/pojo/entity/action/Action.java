package com.iothomehero.pojo.entity.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    private Integer id;
    private Integer routineId;
    private Short actionType;
    private Integer actionId;


}
