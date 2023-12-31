package id.co.mii.serverApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.serverApp.models.Project;
import id.co.mii.serverApp.models.dto.request.ProjectRequest;
import id.co.mii.serverApp.services.ProjectService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/manager")
    public List<Project> getByManagerId() {
        return projectService.getByManagerId();
    }

    @GetMapping("/employee")
    public List<Project> getByEmployeeId() {
        return projectService.getByEmployeeId();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Integer id) {
        return projectService.getById(id);
    }

    @PostMapping
    public Project create(@RequestBody ProjectRequest projectRequest) {
        return projectService.create(projectRequest);
    }

    @PutMapping("/{id}")
    public Project update(
            @PathVariable Integer id,
            @RequestBody ProjectRequest projectRequest) {
        return projectService.update(id, projectRequest);
    }

    @DeleteMapping("/{id}")
    public Project delete(@PathVariable Integer id) {
        return projectService.delete(id);
    }
}
