package pw.ersms.emergencies.emergency;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("emergency")
@SecurityRequirement(name = "Bearer Authentication")
public class EmergencyController {
    private final EmergencyService emergencyService;

    @GetMapping(path = "/{departmentId}")
    public List<Emergency> getEmergency(@PathVariable("departmentId") Integer departmentId) {
        return emergencyService.get(departmentId);
    }

    @GetMapping(path = "/{departmentId}/{id}")
    public Emergency getEmergencyById(@PathVariable("id") Integer id) {
        return emergencyService.getEmergencyById(id);
    }

    @GetMapping
    public ResponseEntity<List<Emergency>> getEmergency(Principal principal) {
        //get first element of userDetails.getAuthorities()
        UserDetails userDetails = (UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        //check if getAuthorities() returns a list of size 2
        if (userDetails.getAuthorities().size() != 2) {
            throw new BadCredentialsException("Invalid credentials");
        }

        //departmentId
        System.out.println(userDetails.getAuthorities().toArray()[0]);
        Integer departmentId = Integer.parseInt(userDetails.getAuthorities().toArray()[0].toString());

        //role
        System.out.println(userDetails.getAuthorities().toArray()[1]);
        String role = userDetails.getAuthorities().toArray()[1].toString();

        if (role.equals("SysAdmin")) {
            return ResponseEntity.ok().body(emergencyService.get());
        } else if (role.equals("FireAdmin")) {
            return ResponseEntity.ok().body(emergencyService.get(departmentId));
        } else {
            //return unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
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
