package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.service.MemoryServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/digix")
public class MemoriesController implements MemoriesControllerInterface {

    @Autowired
    private MemoryServiceContract memoryService;

    @RequestMapping("/memories")
    @Override
    public List<Memory> getMemories() {

        return memoryService.getMemoryByType("txt");
    }

    @Override
    @RequestMapping("/memories/{id}")
    public Memory getMemory(long id) {
        return new Memory();
    }

    @RequestMapping(value = "/memories", method = RequestMethod.POST)
    @Override
    public Memory uploadMemory(@RequestBody Memory memory) {
        return memoryService.uploadMemory(memory);
    }

}
