package pw.ersms.emergencies.emergency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pw.ersms.emergencies.classification.Classification;
import pw.ersms.emergencies.classification.ClassificationRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmergencyServiceTest {

    @Mock
    private EmergencyRepository emergencyRepository;

    @Mock
    private ClassificationRepository classificationRepository;

    @InjectMocks
    private EmergencyService emergencyService;

    private Emergency emergency;
    private Classification classification;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        emergency = new Emergency();
        classification = new Classification();
    }

    @Test
    void get() {
        when(emergencyRepository.findAll()).thenReturn(Arrays.asList(emergency));
        assertNotNull(emergencyService.get());
    }

    @Test
    void getEmergencyById() {
        when(emergencyRepository.findById(emergency.getId())).thenReturn(Optional.ofNullable(emergency));
        assertNotNull(emergencyService.getEmergencyById(emergency.getId()));
    }

    @Test
    void create() {
        classification.setId(1);
        emergency.setClassification(classification);

        when(classificationRepository.findClassificationById(classification.getId())).thenReturn(Optional.of(classification));
        when(emergencyRepository.save(emergency)).thenReturn(emergency);

        // Call the method under test
        Emergency result = emergencyService.create(emergency);

        assertNotNull(result);
        assertEquals(emergency, result);
    }

    @Test
    void updateEmergency() {
        // Create a test emergency ID, emergency, and classification
        Integer emergencyId = 1;
        emergency.setAddressLine2("Updated Address Line 2");
        classification.setId(1);
        emergency.setClassification(classification);

        when(emergencyRepository.findById(emergencyId)).thenReturn(Optional.of(emergency));
        when(classificationRepository.findClassificationById(classification.getId())).thenReturn(Optional.of(classification));
        when(emergencyRepository.save(emergency)).thenReturn(emergency);

        // Create an instance of the service and inject the mock repositories
        EmergencyService emergencyService = new EmergencyService(emergencyRepository, classificationRepository);

        // Call the method under test
        Emergency result = emergencyService.updateEmergency(emergencyId, emergency);

        assertNotNull(result);
        assertEquals(emergency, result);
    }
}