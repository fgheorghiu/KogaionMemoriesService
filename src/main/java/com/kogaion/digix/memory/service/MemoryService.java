package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.controller.FileHandlerController;
import com.kogaion.digix.memory.controller.S3Controller;
import com.kogaion.digix.memory.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@ComponentScan({"com.kogaion.digix.memory.repository.*"})
public class MemoryService implements MemoryServiceContract {

    @Autowired
    private MemoryRepository memoryRepository;

    private S3Controller s3Controller;

    @Autowired
    private FileHandlerController fileHandlerController;

    @Override
    public Memory uploadMemory(Memory memory) {

        memoryRepository.save(memory);
        fileHandlerController.uploadBase64File(memory);

        long id = memory.getId();

        return findMemory(id);
    }

    @Override
    public Memory findMemory(long id) {

        Memory memory = new Memory();
        // memoryRepository.findById(id).get();

        return memory;
    }

    @Override
    public Memory saveMemory(Memory memory) {

        memoryRepository.save(memory);

        return new Memory();
    }

    @Override
    public List<Memory> getMemoryByType(String extension) {

        return getListFromIterator(memoryRepository.findAll().iterator());
    }

    private List<Memory> getListFromIterator(Iterator<Memory> iterator)
    {
        // Create an empty list
        List<Memory> list = new ArrayList<>();

        // Add each element of iterator to the List
        iterator.forEachRemaining(list::add);

        // Return the List
        return list;
    }
}
