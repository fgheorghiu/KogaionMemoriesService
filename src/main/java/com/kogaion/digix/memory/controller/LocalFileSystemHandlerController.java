package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    @Override
    public ResponseEntity<String> uploadFile(Memory memory) {

        String path;

        if(checkIfUserFolderExists(memory.getOwnerId()) == false) {

            path = System.getProperty("user.dir") + File.separator;

            this.createDir(path, memory.getOwnerId());

            path += memory.getOwnerId();
        } else {
            path = System.getProperty("user.dir") + File.separator + memory.getOwnerId();
        }

        byte[] bytes = new byte[0];

        if (checkIfFolderExists(path + File.separator + memory.getBoxName()) == false) {
            System.out.println("test - " + path + File.separator + memory.getBoxName());
            createDir(path.replace(";", File.separator), memory.getBoxName());
            path += File.separator + memory.getBoxName();
        } else {
            path += File.separator + memory.getBoxName();
        }

        System.out.println("Path is " + path);

        try (FileOutputStream fos = new FileOutputStream(path + File.separator + memory.getFilename() + "." + memory.getFileExtension())) {
            bytes = memory.getFile().getBytes();
            fos.write(bytes);
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("IO Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Memory not uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> createUserDirectory(String userId) {

        this.createDir("", userId);

        return new ResponseEntity<>("User directory created", HttpStatus.OK);
    }

    @Override
    public boolean checkIfUserFolderExists(String ownerId) {

        File dir = new File(System.getProperty("user.dir").replace(";", File.separator) + File.pathSeparator + ownerId);

        return (dir.exists() && dir.isDirectory());
    }

    @Override
    public boolean checkIfFolderExists(String path) {
        File dir = new File(path);

        return dir.exists() && dir.isDirectory();
    }

    @Override
    public void createDir(String path, String dirName) {
        // System.out.println(path.replace(";", File.separator) + dirName);
        System.out.println("Create dir path - " + path);
        System.out.println("Create dir dirName - " + dirName);

        new File(path.replace(";", File.separator) + File.separator + dirName).mkdir();
    }

    @Override
    public List<String> getBoxContent(String ownerId, String path) {

        String searchPath = System.getProperty("user.dir") + File.separator + ownerId + File.separator + path;

        List<String> boxContent = new ArrayList<>();

        File folder = new File(searchPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                boxContent.add(file.getName());
            }
        }

        return boxContent;
    }

}