package com.kogaion.digix.entities;

import java.util.List;

public class Box {

    private String name;
    private List<Long> memoriesIds;
    private String ownerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getMemoriesIds() {
        return memoriesIds;
    }

    public void setMemoriesIds(List<Long> memoriesIds) {
        this.memoriesIds = memoriesIds;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
