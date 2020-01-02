package com.kogaion.digix.memory.controller;

import java.util.List;

public interface LocalFileSystemHandlerInterface extends FileSystemHandlerInterface {

    boolean checkIfUserFolderExists(String ownerId);

    boolean checkIfFolderExists(String path);

    void createDir(String path, String dirName);

    List<String> getBoxContent(String ownerId, String path);
}
