package com.kogaion.memoriesservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/digix")
public class MemoriesController implements MemoriesControllerInterface {

    @RequestMapping("/memories")
    @Override
    public String getMemories() {
        return "test";
    }

    @Override
    @RequestMapping("/memories/{id}")
    public Memory getMemory(long id) {
        return new Memory();
    }

}
