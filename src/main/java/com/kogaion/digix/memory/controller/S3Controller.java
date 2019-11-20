package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;

import java.io.File;

public class S3Controller implements S3ControllerInterface {

    @Override
    public void uploadFileToS3(File f) {
        System.out.println("Uploaded to S3");
    }

    public void uploadFile(File f) {

    }

    @Override
    public void uploadBase64File(Memory memory) {

    }
}
