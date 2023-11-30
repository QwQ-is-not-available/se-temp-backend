package com.tempomate.pojo.entity.trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriTime {
    private Integer id;

    private String time;

//    public TriTime(String time){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        this.time = LocalDateTime.parse(time,formatter);
//    }


}
