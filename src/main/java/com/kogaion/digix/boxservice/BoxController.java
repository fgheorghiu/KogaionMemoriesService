package com.kogaion.digix.boxservice;

import com.kogaion.digix.entities.Box;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Component
@RequestMapping("/digix")
@RestController
public class BoxController implements BoxControllerInterface {

    @RequestMapping("/boxes")
    @Override
    public List<Box> getDigitalBoxes() {
        return new ArrayList<>();
    }

    @RequestMapping("/boxes/{id}")
    @Override
    public Box getBox(long id) {
        return new Box();
    }
}
