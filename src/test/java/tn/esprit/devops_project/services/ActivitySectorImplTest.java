package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ActivitySectorImplTest {

    @InjectMocks
    ActivitySectorImpl iActivitySector;
    @Mock
    ActivitySectorRepository  activitySectorRepository;

    ActivitySector activitySector1 = new ActivitySector(1L,"NEW STOCK TEST 1",null,null);

    @Test
    void retrieveAllActivitySectors() {
    }

    @Test
    void addActivitySector() {
    }

    @Test
    void deleteActivitySector() {
    }

    @Test
    void updateActivitySector() {
    }

    @Test
    void retrieveActivitySector() {
        /*
        Mockito.when(activitySectorRepository.findById(1L)).thenReturn(Optional.of(activitySector1));
        ActivitySector stock = iActivitySector.retrieveActivitySector(1L);
        assertNotNull(stock);

         */
    }
}