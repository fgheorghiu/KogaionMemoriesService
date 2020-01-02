package com.kogaion.digix.box.controller;

import com.kogaion.digix.entities.Box;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoxControllerInterface {

    List<Box> getDigitalBoxes(String ownerId);

//    Box getBox(long id);

    List<String> getBoxContentByName(String ownerId, String boxName);

    Box createBox(String name, String ownerId);
}
