package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryRepositoryImpl implements MemoryRepository{


    @Override
    public Memory findMemory(long id) {
        return new Memory();
    }

    @Override
    public List<Memory> findMemoriesByType(String type) {
        Memory memory = new Memory();

        ArrayList<Memory> memories = new ArrayList<Memory>();
        memories.add(memory);
        memories.add(memory);
        memories.add(memory);

        return memories;
    }

    @Override
    public Memory findMemoriesByTags(List<String> tags) {
        return null;
    }
}
