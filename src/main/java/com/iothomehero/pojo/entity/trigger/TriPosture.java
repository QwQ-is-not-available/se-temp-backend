package com.iothomehero.pojo.entity.trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriPosture {
    private Integer id;
    private Short mode;
    private Integer coX;
    private Integer coY;
    private String ip;
}