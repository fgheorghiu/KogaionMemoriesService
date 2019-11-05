package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;

import java.util.List;

public interface MemoriesControllerInterface {

    public List<Memory> getMemories();

    public Memory getMemory(long id);

    public Memory uploadMemory(Memory memory);
}
