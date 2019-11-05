package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Service;

@Service
public class MemoryService implements MemoryServiceContract {

    @Override
    public Memory uploadMemory(Memory memory) {

        return new Memory();
    }
}
