package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoryService implements MemoryServiceContract {

    @Autowired
    private MemoryRepository memoryRepository;

    @Override
    public Memory uploadMemory(Memory memory) {

        return new Memory();
    }

    @Override
    public Memory findMemory(long id) {

        return memoryRepository.findMemory(id);
    }
}
