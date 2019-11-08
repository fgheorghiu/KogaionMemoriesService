package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryRepositoryFileSystem implements MemoryRepository {

    @Override
    public Memory findMemory(long id) {

        return null;
    }

    @Override
    public List<Memory> findMemoriesByType(String type) {

        return null;
    }

    @Override
    public Memory findMemoriesByTags(List<String> tags) {

        return null;
    }

    @Override
    public Memory saveMemory(Memory memory) {

        System.out.println("Saved to local file system");

        return new Memory();
    }


}
