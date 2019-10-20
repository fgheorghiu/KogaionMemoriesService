package com.kogaion.digix.memoryservice;

import com.kogaion.digix.entities.Memory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/digix")
public class MemoriesController implements MemoriesControllerInterface {

    @RequestMapping("/memories")
    @Override
    public List<Memory> getMemories() {

        Memory memory = new Memory();
        memory.setFileExtension("txt");
        memory.setId(1L);
        memory.setOwnerId(0L);

        List<Memory> sampleMemoriesList = new ArrayList<>();
        sampleMemoriesList.add(memory);

        return sampleMemoriesList;
    }

    @Override
    @RequestMapping("/memories/{id}")
    public Memory getMemory(long id) {
        return new Memory();
    }

}
