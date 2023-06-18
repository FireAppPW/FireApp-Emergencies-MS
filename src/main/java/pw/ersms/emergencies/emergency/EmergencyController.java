package pw.ersms.emergencies.emergency;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("emergency")
public class EmergencyController {
    private final EmergencyService emergencyService;

    @GetMapping
    public List<Emergency> getEmergency() {
        return emergencyService.get();
    }
    @GetMapping(path = "/{departmentId}")
    public List<Emergency> getEmergency(@PathVariable("departmentId") Integer departmentId) {
        return emergencyService.get(departmentId);
    }

    @GetMapping(path = "/{departmentId}/{id}")
    public Emergency getEmergencyById(@PathVariable("id") Integer id) {
        return emergencyService.getEmergencyById(id);
    }

    @PostMapping
    public Emergency registerNewEmergency(@RequestBody Emergency emergency) {
        return emergencyService.create(emergency);
    }

    @PutMapping(path = "/{departmentId}/{id}")
    public Emergency updateEmergency(
            @PathVariable("id") Integer id,
            @RequestBody Emergency emergency) {
        return emergencyService.updateEmergency(id, emergency);
    }
}
