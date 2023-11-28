package com.iothomehero.pojo.entity.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActTime {
    private Integer id;
    private Integer routineId;
    private String time;
    private Integer order1;

}
