package com.kogaion.digix.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fileSystem")
public class FileSystemController implements FileSystemControllerContract {

    @Autowired
    LocalFileSystemHandlerInterface localFileSystemHandler;

    @Override
    @RequestMapping(value = "/createDir", method = RequestMethod.POST)
    public ResponseEntity<String> createUserDir(@RequestBody String userId) {
        System.out.println(userId);
        return localFileSystemHandler.createUserDirectory(userId);
    }
}
