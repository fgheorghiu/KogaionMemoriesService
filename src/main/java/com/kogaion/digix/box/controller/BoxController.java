package com.kogaion.digix.box.controller;

import com.kogaion.digix.entities.Box;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequestMapping("/digix")
@RestController
public class BoxController implements BoxControllerInterface {

    @RequestMapping("/boxes")
    @Override
    public List<Box> getDigitalBoxes() {

        Box box = new Box();

        Long[] memoryIds = new Long[] {1L, 2L, 3L};
        box.setMemoriesIds(Arrays.asList(memoryIds));
        box.setName("faculty memories");

        List<Box> sampleBoxList = new ArrayList<>();
        sampleBoxList.add(box);

        return sampleBoxList;
    }

    @RequestMapping("/boxes/{id}")
    @Override
    public Box getBox(long id) {
        return new Box();
    }
}
