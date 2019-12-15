package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MemoriesControllerInterface {

    List<Memory> getMemories();

    Memory getMemory(long id);

    Memory uploadMemory(Memory memory);

    List<Memory> getPagedMemories(int startIndex, int size);

    List<String> getMemoriesForUser(String userId);

    ResponseEntity<String> deleteMemory(Memory memory);
}
