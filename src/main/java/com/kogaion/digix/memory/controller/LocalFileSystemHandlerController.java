package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Component
public class LocalFileSystemHandlerController implements LocalFileSystemHandlerInterface {

    @Override
    public ResponseEntity<String> uploadBase64File(Memory memory) {

        byte[] result = Base64.getDecoder().decode(memory.getBase64File());
        String path;

        if(checkIfUserFolderExists(memory.getOwnerId()) == false) {

            path = System.getProperty("user.dir") + File.separator;

            this.createDir(path, memory.getOwnerId());

            path += memory.getOwnerId();
        } else {
            path = System.getProperty("user.dir") + File.separator + memory.getOwnerId();
        }
        try (FileOutputStream fos = new FileOutputStream(path + File.separator + memory.getOwnerId() + "_" + memory.getFilename())) {

            fos.write(result);
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("IO Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("File uploaded", HttpStatus.OK);
    }

    private boolean checkIfUserFolderExists(String ownerId) {

        File dir = new File(System.getProperty("user.dir") + File.pathSeparator + ownerId);

        return (dir.exists() && dir.isDirectory());
    }

    private void createDir(String path, String dirName) {
        // System.out.println(path.replace(";", File.separator) + dirName);
        new File(path.replace(";", File.separator) + dirName).mkdir();
    }
}