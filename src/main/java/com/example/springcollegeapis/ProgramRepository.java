package com.example.springcollegeapis;

import org.springframework.data.repository.CrudRepository;

public interface ProgramRepository extends CrudRepository<Program, Integer>{
    Program getProgramsByPid (Integer pid);
}
