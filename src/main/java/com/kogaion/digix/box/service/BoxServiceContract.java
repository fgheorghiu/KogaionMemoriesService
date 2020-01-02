package com.kogaion.digix.box.service;

import com.kogaion.digix.entities.Box;

import java.util.List;

public interface BoxServiceContract {

    Box createBox(String name, String ownerId);

    Box getBox(long id);

    List<Box> getBoxes(String ownerId);

}