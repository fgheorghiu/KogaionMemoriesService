package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MemoriesControllerInterface {

    List<Memory> getMemories();

    Memory getMemory(long id);

    ResponseEntity<String> uploadMemory(@RequestParam("file") MultipartFile file,
                                        @RequestParam("id") long id,
                                        @RequestParam("ownerId") String ownerId,
                                        @RequestParam("filename") String filename,
                                        @RequestParam("fileExtension") String fileExtension,
                                        @RequestParam("boxName") String boxName);

    List<Memory> getPagedMemories(int startIndex, int size);

    List<String> getMemoriesForUser(String userId);

    ResponseEntity<String> deleteMemory(Memory memory);
}
