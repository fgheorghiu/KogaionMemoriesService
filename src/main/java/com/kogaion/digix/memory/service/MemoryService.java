package com.kogaion.digix.memory.service;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.controller.LocalFileSystemHandlerInterface;
import com.kogaion.digix.memory.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ComponentScan({"com.kogaion.digix.memory.repository.*"})
public class MemoryService implements MemoryServiceContract {

    @Autowired
    private MemoryRepository memoryRepository;

    @Autowired
    private LocalFileSystemHandlerInterface fileHandlerController;

    @Override
    public Memory uploadMemory(Memory memory) {

        memoryRepository.save(memory);
        fileHandlerController.uploadBase64File(memory);

        return memory;
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

    @Override
    public List<String> getMemoriesForUserId(String userId) {

        List<String> result = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get(System.getProperty("user.dir") + File.separator + userId))) {

            result = walk.map(x -> x.toString())
                    .filter(f -> f.contains(userId)).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ResponseEntity<String> deleteMemory(Memory memory) {

        String path = System.getProperty("user.dir") + File.separator + memory.getOwnerId();

        File memoryFile = new File(path + File.separator + memory.getOwnerId() + "_" + memory.getFilename());

        if(memoryFile.delete())
            return new ResponseEntity("File deleted", HttpStatus.OK);
        else
            return new ResponseEntity("File not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
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
