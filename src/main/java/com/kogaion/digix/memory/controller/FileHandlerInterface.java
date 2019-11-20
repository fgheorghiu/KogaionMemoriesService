package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public interface FileHandlerInterface {

    void uploadBase64File(Memory memory);

}
