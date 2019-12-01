package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

@Component
public interface FileSystemHandlerInterface {

    void uploadBase64File(Memory memory);

}
