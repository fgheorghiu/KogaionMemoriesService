package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

@Component
public interface MemoryServiceContract {

    Memory uploadMemory(Memory memory);

}