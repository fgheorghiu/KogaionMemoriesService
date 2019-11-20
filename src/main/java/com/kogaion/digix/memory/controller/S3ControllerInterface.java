package com.kogaion.digix.memory.controller;

import java.io.File;

public interface S3ControllerInterface extends FileHandlerInterface{

    void uploadFileToS3(File f);
}
