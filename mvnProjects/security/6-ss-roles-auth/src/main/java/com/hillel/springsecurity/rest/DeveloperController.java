package com.hillel.springsecurity.rest;

import com.hillel.springsecurity.model.Developer;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dev")
public class DeveloperController {
    private List<Developer> DEVELOPERS = new ArrayList<>(Arrays.asList(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Petr", "Petrov"),
            new Developer(3L, "Sidr", "Sidorov")
    ));

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @Secured({"ADMIN", "USER"})
    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Secured({"ADMIN"})
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Developer create(@RequestBody Developer developer){
        DEVELOPERS.add(developer);
        return developer;
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Long id){
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
