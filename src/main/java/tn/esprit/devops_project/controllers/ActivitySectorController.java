package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.dto.ActivitySectorDto;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.services.Iservices.IActivitySector;

import java.util.List;

@RestController
@AllArgsConstructor
public class ActivitySectorController {

    IActivitySector activitySectorService;

    @GetMapping("/activitySector")
    List<ActivitySector> retrieveAllActivitySectors() {
        return activitySectorService.retrieveAllActivitySectors();
    }

    @PostMapping("/activitySector")
    ActivitySectorDto addActivitySector(@RequestBody ActivitySectorDto activitySectorDto) {
        ActivitySector activitySector = convertDTOToEntity(activitySectorDto);
        return ActivitySectorDto.fromEntity(activitySectorService.addActivitySector(activitySector));
    }

    @DeleteMapping("/activitySector/{id}")
    void deleteActivitySector(@PathVariable Long id) {
        activitySectorService.deleteActivitySector(id);
    }

    @PutMapping("/activitySector")
    ActivitySectorDto updateActivitySector(@RequestBody ActivitySectorDto activitySectorDto) {
        ActivitySector activitySector = convertDTOToEntity(activitySectorDto);
        return ActivitySectorDto.fromEntity(activitySectorService.updateActivitySector(activitySector));
    }

    @GetMapping("/activitySector/{id}")
    ActivitySector retrieveActivitySector(@PathVariable Long id) {
        return activitySectorService.retrieveActivitySector(id);
    }

    private tn.esprit.devops_project.entities.ActivitySector convertDTOToEntity(ActivitySectorDto activitySectorDTO) {
        tn.esprit.devops_project.entities.ActivitySector activitySector = new tn.esprit.devops_project.entities.ActivitySector();
        activitySector.setIdSecteurActivite(activitySectorDTO.getIdSecteurActivite());
        activitySector.setCodeSecteurActivite(activitySectorDTO.getCodeSecteurActivite());
        activitySector.setLibelleSecteurActivite(activitySectorDTO.getLibelleSecteurActivite());
        // Set other properties as needed
        return activitySector;
    }
}
