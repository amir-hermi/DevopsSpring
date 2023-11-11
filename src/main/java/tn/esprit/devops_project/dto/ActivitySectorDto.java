package tn.esprit.devops_project.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySectorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    Long idSecteurActivite;
    String codeSecteurActivite;
    String libelleSecteurActivite;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public ActivitySectorDto(tn.esprit.devops_project.entities.ActivitySector activitySector) {
        this.idSecteurActivite = activitySector.getIdSecteurActivite();
        this.codeSecteurActivite = activitySector.getCodeSecteurActivite();
        this.libelleSecteurActivite = activitySector.getLibelleSecteurActivite();
        // You can map other fields if needed
    }

    // Additional static method for conversion if needed
    public static ActivitySectorDto fromEntity(tn.esprit.devops_project.entities.ActivitySector activitySector) {
        return new ActivitySectorDto(activitySector);
    }
}

