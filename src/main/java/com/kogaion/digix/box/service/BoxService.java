package com.kogaion.digix.box.service;

import com.kogaion.digix.entities.Box;
import com.kogaion.digix.memory.controller.LocalFileSystemHandlerController;
import com.kogaion.digix.memory.controller.LocalFileSystemHandlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Component
@ComponentScan({"com.kogaion.digix.memory.*"})
public class BoxService implements BoxServiceContract {

    @Autowired
    LocalFileSystemHandlerInterface localFileSystemHandler;

    @Override
    public Box createBox(String name, String ownerId) {

        Box result = new Box();
        result.setName(name);
        result.setOwnerId(ownerId);

        String path;

        if(localFileSystemHandler.checkIfUserFolderExists(ownerId) == false) {

            path = System.getProperty("user.dir") + File.separator;

            localFileSystemHandler.createDir(path, ownerId);

            path += ownerId;

            new File(System.getProperty("user.dir").replace(";", File.separator) + File.separator + ownerId + File.separator + name);
        } else {
            path = path = System.getProperty("user.dir") + File.separator + ownerId;
        }

        if (localFileSystemHandler.checkIfFolderExists(path + File.separator + name) == false) {

            localFileSystemHandler.createDir(path.replace(";", File.separator), name);
            path += File.separator + name;
        }

        return result;
    }

    @Override
    public Box getBox(long id) {
        return null;
    }

    @Override
    public List<Box> getBoxes(String ownerId) {
        return null;
    }
}
