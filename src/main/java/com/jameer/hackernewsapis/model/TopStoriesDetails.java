package com.jameer.hackernewsapis.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TopStoriesDetails implements Serializable{
    @Id
    private Integer id;
    private String by;
    private int score;
    private String time;
    private String title;
    private String url;
    // private transient List<Integer>kids;
}
