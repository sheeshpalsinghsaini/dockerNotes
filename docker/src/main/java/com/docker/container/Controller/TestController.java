package com.docker.container.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getData")
    public Map<String, Object> getValues(){
        Map<String, Object> data = new HashMap<>();

        data.put("message","java api is working fine");
        data.put("language", Arrays.asList("Java","Python","Javascript"));
        data.put("code",2345);

        return data;
    }
}
