package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemoryRepository {

    Memory findMemory(long id);

    List<Memory> findMemoriesByType(String type);

    Memory findMemoriesByTags(List<String> tags);

    Memory saveMemory(Memory memory);
}
