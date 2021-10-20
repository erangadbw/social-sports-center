package yield.broker.social.sports.center.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/register")
public class RegistrationController {

    private final RegistrationService registrationService;;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping
    public void addNewRegistration(@RequestBody Registration registration) {

        registrationService.addNewRegistration(registration);

    }

}
