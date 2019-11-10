package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryRepo {

    public MemoryRepo() {

    }

    List<Memory> findByExtension(String extension) {

        Memory memory = new Memory();
        memory.setFileExtension("txt");
        memory.setOwnerId(1234);
        memory.setId(1);

        List<Memory> result = new ArrayList<>();
        result.add(memory);

        return result;
    }
}
