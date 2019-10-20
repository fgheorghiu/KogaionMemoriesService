package com.kogaion.digix.memoryservice;

import com.kogaion.digix.entities.Memory;

import java.util.List;

public interface MemoriesControllerInterface {

    public List<Memory> getMemories();

    public Memory getMemory(long id);


}
