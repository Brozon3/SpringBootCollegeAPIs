package com.example.springcollegeapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/program")
public class ProgramController {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramController(ProgramRepository programRepository) { this.programRepository = programRepository; }

    @PostMapping("/add")
    public String addProgram(@RequestParam String programName, @RequestParam String campus) {
        Program program = new Program();
        program.setProgramName(programName);
        program.setCampus(campus);
        programRepository.save(program);
        return String.format("Added %s to the program table for campus %s.", programName, campus);
    }

    @GetMapping("/view/{id}")
    public Program viewProgram(@PathVariable Integer id){
        return programRepository.getProgramsByPid(id);
    }

    @GetMapping("/list")
    public Iterable<Program> getPrograms(){
        return programRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProgram(@PathVariable Integer id) {
        programRepository.deleteById(id);
        return String.format("Deleted program %d", id);
    }
}
