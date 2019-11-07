package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;

import java.util.List;

public class MemoryRepositoryS3 implements MemoryRepository {

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
        return null;
    }

}
