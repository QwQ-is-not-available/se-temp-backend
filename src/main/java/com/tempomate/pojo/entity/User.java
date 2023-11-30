package com.tempomate.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userId;
    private String nickname;
    private String password;
    private String token;
    private Short pushSetting;

}
