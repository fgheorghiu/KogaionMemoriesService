package com.kogaion.digix.entities;

import javax.persistence.*;

@Table
@Entity(name = "memory")
public class Memory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String fileExtension;

    private long ownerId;

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
