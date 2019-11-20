package com.kogaion.digix.memory.repository;

import com.kogaion.digix.entities.Memory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends CrudRepository<Memory, Long> {

}
