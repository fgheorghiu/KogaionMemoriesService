package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface FileSystemHandlerInterface {

    ResponseEntity<String> uploadBase64File(Memory memory);

    ResponseEntity<String> uploadFile(Memory memory);

    ResponseEntity<String> createUserDirectory(String userId);
}
