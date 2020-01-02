package com.kogaion.digix.memory.controller;

import org.springframework.http.ResponseEntity;

public interface FileSystemControllerContract {

    ResponseEntity<String> createUserDir(String userId);
}
