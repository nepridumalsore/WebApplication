package org.example.Model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data

public class Model {
    private int id;
    private String name;
    private String email;
    private Map<String, Object> attributes = new HashMap<>();

    public void addAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}



