package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemoryServiceContract {

    Memory uploadMemory(Memory memory);

    Memory findMemory(long id);

    Memory saveMemory(Memory memory);

    List<Memory> getMemoryByType(String extension);

    List<String> getMemoriesForUserId(String userId);

    ResponseEntity<String> deleteMemory(Memory memory);
}