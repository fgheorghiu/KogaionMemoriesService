package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.repository.MemoryRepository;
import com.kogaion.digix.memory.repository.MemoryRepositoryFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryService implements MemoryServiceContract {

    @Autowired
    private MemoryRepositoryFileSystem memoryRepositoryFileSystem;

    @Override
    public Memory uploadMemory(Memory memory) {

        return memoryRepositoryFileSystem.saveMemory(memory);
    }

    @Override
    public Memory findMemory(long id) {

        return memoryRepositoryFileSystem.findMemory(id);
    }

    @Override
    public Memory saveMemory(Memory memory) {

        return memoryRepositoryFileSystem.saveMemory(memory);
    }

    @Override
    public List<Memory> getMemoryByType(String extension) {
        return memoryRepositoryFileSystem.findMemoriesByType("txt");
    }
}
