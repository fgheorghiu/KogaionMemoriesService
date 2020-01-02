package com.kogaion.digix.box.controller;

import com.kogaion.digix.box.service.BoxServiceContract;
import com.kogaion.digix.entities.Box;
import com.kogaion.digix.memory.controller.LocalFileSystemHandlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RequestMapping("/digix")
@RestController
public class BoxController implements BoxControllerInterface {

    private LocalFileSystemHandlerController localFileSystemHandlerController = new LocalFileSystemHandlerController();

    @Autowired
    private BoxServiceContract boxService;

    @RequestMapping(value = "/boxes", method = RequestMethod.GET)
    @Override
    public List<Box> getDigitalBoxes(@RequestParam("ownerId") String ownerId) {
        return boxService.getBoxes(ownerId);
    }

//    @RequestMapping(value = "/boxes/{id}", method = RequestMethod.GET)
//    @Override
//    public Box getBox(@RequestParam long id) {
//        return boxService.getBox(id);
//    }

    @RequestMapping(value = "/boxes/content", method = RequestMethod.POST)
    @Override
    public List<String> getBoxContentByName(@RequestParam("ownerId") String ownerId, @RequestParam("boxName") String boxName) {
        return localFileSystemHandlerController.getBoxContent(ownerId, boxName);
    }

    @RequestMapping(value = "/boxes", method = RequestMethod.POST)
    @Override
    public Box createBox(@RequestParam("name") String name, @RequestParam("ownerId") String ownerId) {

        boxService.createBox(name, ownerId);

        return new Box(); //boxService.createBox(name, ownerId);
    }
}
