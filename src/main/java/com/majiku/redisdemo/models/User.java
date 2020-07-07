package com.majiku.redisdemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private String id;
    private String name;
    private Long score;

}
