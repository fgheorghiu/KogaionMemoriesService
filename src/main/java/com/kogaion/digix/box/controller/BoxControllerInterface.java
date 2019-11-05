package com.kogaion.digix.box.controller;

import com.kogaion.digix.entities.Box;

import java.util.List;

public interface BoxControllerInterface {

    public List<Box> getDigitalBoxes();

    public Box getBox(long id);
}
