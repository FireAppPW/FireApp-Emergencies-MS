package pw.ersms.emergencies.emergency;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pw.ersms.emergencies.classification.Classification;
import pw.ersms.emergencies.classification.ClassificationRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EmergencyService {
    private final EmergencyRepository emergencyRepository;

    private final ClassificationRepository classificationRepository;

    public List<Emergency> get(Integer departmentId) {
        System.out.println("departmentId: " + departmentId);
        return emergencyRepository.findAll().stream()
                .filter(emergency -> emergency.getFireDepartmentId().equals(departmentId))
                .collect(java.util.stream.Collectors.toList());
    }

    public Emergency getEmergencyById(Integer emergencyId) {
        return emergencyRepository.findById(emergencyId)
                .orElseThrow(() -> new IllegalStateException(
                        "emergency with id " + emergencyId + " does not exist"
                ));
    }

    public Emergency create(Emergency emergency) {
        //check if classification exists
        Optional<Classification> classificationOptional = classificationRepository.findClassificationById(emergency.getClassification().getId());

        if (!classificationOptional.isPresent()) {
            throw new IllegalStateException("classification does not exist");
        }

        //set classification
        emergency.setClassification(classificationOptional.get());

        return emergencyRepository.save(emergency);
    }

    public Emergency updateEmergency(Integer emergencyId, Emergency emergency) {
        Emergency emergencyNew = emergencyRepository.findById(emergencyId)
                .orElseThrow(() -> new IllegalStateException(
                        "emergency with id " + emergencyId + " does not exist"
                ));

        //check if classification exists
        Optional<Classification> classificationOptional = classificationRepository.findClassificationById(emergency.getClassification().getId());

        if (!classificationOptional.isPresent()) {
            throw new IllegalStateException("classification does not exist");
        }

        //set classification
        emergencyNew.setClassification(classificationOptional.get());

        //if field is null, do not update
        if (emergency.getAddressLine2() != null) {
            emergencyNew.setAddressLine2(emergency.getAddressLine2());
        }

        //if dateTimeClosed is null, do not update
        if (emergency.getDateTimeClosed() != null) {
            emergencyNew.setDateTimeClosed(emergency.getDateTimeClosed());
        }

        return emergencyRepository.save(emergencyNew);
    }
}
