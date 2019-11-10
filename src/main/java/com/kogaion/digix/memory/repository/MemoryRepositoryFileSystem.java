package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryRepositoryFileSystem implements MemoryRepository {

    @Autowired
    MemoryRepo memoryRepo;

    @Override
    public Memory findMemory(long id) {

        return null;
    }

    @Override
    public List<Memory> findMemoriesByType(String type) {

        return memoryRepo.findByExtension(type);
    }

    @Override
    public Memory findMemoriesByTags(List<String> tags) {

        return null;
    }

    @Override
    public Memory saveMemory(Memory memory) {

        //memoryRepo.save(memory);

        return memory;
    }


}
