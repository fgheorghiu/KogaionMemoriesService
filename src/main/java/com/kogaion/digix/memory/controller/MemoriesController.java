package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import com.kogaion.digix.memory.service.MemoryService;
import com.kogaion.digix.memory.service.MemoryServiceConstants;
import com.kogaion.digix.memory.service.MemoryServiceContract;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/digix")
public class MemoriesController implements MemoriesControllerInterface {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping(value = "/memories", method = RequestMethod.GET)
    @Override
    public List<Memory> getMemories() {

        return memoryService.getMemoryByType("txt");
    }

    @Override
    @RequestMapping(value = "/memories/{id}", method = RequestMethod.GET)
    public Memory getMemory(long id) {
        return new Memory();
    }

    @RequestMapping(value = "/memories", method = RequestMethod.POST)
    @Override
    public ResponseEntity<String> uploadMemory(@RequestParam("file") MultipartFile file,
                                               @RequestParam("id") long id,
                                               @RequestParam("ownerId") String ownerId,
                                               @RequestParam("filename") String filename,
                                               @RequestParam("fileExtension") String fileExtension,
                                               @RequestParam("boxName") String boxName) {

        Memory memory = new Memory();
        memory.setOwnerId(ownerId);
        memory.setId(id);
        memory.setFilename(filename);
        memory.setFileExtension(fileExtension);
        memory.setFile(file);
        memory.setBoxName(boxName);

        if(memory.getBoxName() == null || memory.getBoxName().equals(""))
            return new ResponseEntity<>("Box name not provided", HttpStatus.BAD_REQUEST);

        memoryService.uploadMemory(MemoryServiceConstants.MULTIPART_UPLOAD, memory);

        return new ResponseEntity<>("Memory uploaded", HttpStatus.OK);
    }

    @RequestMapping(value = "/memories/{startIndex}/{size}", method = RequestMethod.GET)
    @Override
    public List<Memory> getPagedMemories(@RequestParam int startIndex, @RequestParam int size) {
        return null;
    }

    @RequestMapping(value = "/memories/user/{userId}", method = RequestMethod.GET)
    @Override
    public List<String> getMemoriesForUser(@PathVariable String userId) {

        return memoryService.getMemoriesForUserId(userId);
    }

    @RequestMapping(value = "/memories", method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<String> deleteMemory(@RequestBody Memory memory) {

        return memoryService.deleteMemory(memory);
    }

}