package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ActivitySectorImplTest {


    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @InjectMocks
    private ActivitySectorImpl iActivitySector;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }




    ActivitySector activitySector1 = new ActivitySector(1L, "NEW STOCK TEST 1", null, null);

    @Test
    void retrieveAllActivitySectors() {
        // Simuler le comportement du repository pour retourner une liste fictive
        List<ActivitySector> fakeActivitySectors = List.of(
                new ActivitySector(1L, "Sector 1", null, null),
                new ActivitySector(2L, "Sector 2", null, null)
                // Ajoutez d'autres secteurs fictifs au besoin
        );
        Mockito.when(activitySectorRepository.findAll()).thenReturn(fakeActivitySectors);

        List<ActivitySector> retrievedSectors = iActivitySector.retrieveAllActivitySectors();
        assertEquals(fakeActivitySectors.size(), retrievedSectors.size());
    }

    @Test
    void addActivitySector() {
        /*
        // Simuler le comportement du repository pour retourner l'entité ajoutée
        Mockito.when(activitySectorRepository.save(Mockito.any(ActivitySector.class))).thenReturn(activitySector1);

        ActivitySector addedSector = iActivitySector.addActivitySector(activitySector1);
        assertNotNull(addedSector);
        assertEquals(activitySector1.getName(), addedSector.getName());

         */
    }

    @Test
    void deleteActivitySector() {
        /*
        // Simuler le comportement du repository lors de la suppression
        Long idToDelete = 1L;
        Mockito.verify(activitySectorRepository, Mockito.times(1)).deleteById(idToDelete);

         */
    }

    @Test
    void updateActivitySector() {
        /*
        // Simuler le comportement du repository pour retourner l'entité mise à jour
        Mockito.when(activitySectorRepository.save(Mockito.any(ActivitySector.class))).thenReturn(activitySector1);

        ActivitySector updatedSector = iActivitySector.updateActivitySector(activitySector1);
        assertNotNull(updatedSector);
        assertEquals(activitySector1.getName(), updatedSector.getName());

         */
    }

    // Le test pour retrieveActivitySector est déjà implémenté dans votre exemple
}
