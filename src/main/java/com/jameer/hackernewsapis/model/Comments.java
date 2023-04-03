package com.jameer.hackernewsapis.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments implements Serializable {
    private String by;
    private String text;
}
