package com.kogaion.memoriesservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MyRestController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "Flv";
    }
}
