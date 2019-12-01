package com.kogaion.digix.memory.controller;

import com.kogaion.digix.entities.Memory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Component
public class LocalFileSystemHandlerController implements LocalFileSystemHandlerInterface {

    @Override
    public void uploadBase64File(Memory memory) {
        byte[] result = Base64.getDecoder().decode(memory.getBase64File());
        try (FileOutputStream fos = new FileOutputStream(memory.getFilename())) {
            fos.write(result);
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
