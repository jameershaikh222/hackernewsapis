package com.jameer.hackernewsapis.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Story implements Serializable{
    private Integer id;
    private String by;
    private int score;
    private String time;
    private String title;
    private String url;
    private List<Integer>kids;
}
