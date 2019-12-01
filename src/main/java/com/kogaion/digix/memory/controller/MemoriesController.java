package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.service.MemoryService;
import com.kogaion.digix.memory.service.MemoryServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/digix")
public class MemoriesController implements MemoriesControllerInterface {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping(value = "/memories", method = RequestMethod.GET)
    @Override
    public List<Memory> getMemories() {

        return memoryService.getMemoryByType("txt");
    }

    @Override
    @RequestMapping(value = "/memories/{id}", method = RequestMethod.GET)
    public Memory getMemory(long id) {
        return new Memory();
    }

    @RequestMapping(value = "/memories", method = RequestMethod.POST)
    @Override
    public Memory uploadMemory(@RequestBody Memory memory) {
        return memoryService.uploadMemory(memory);
    }

    @RequestMapping(value = "/memories/{startIndex}/{size}", method = RequestMethod.GET)
    @Override
    public List<Memory> getPagedMemories(@RequestParam int startIndex, @RequestParam int size) {
        return null;
    }

}
