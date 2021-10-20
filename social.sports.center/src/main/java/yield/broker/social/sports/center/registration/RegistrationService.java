package yield.broker.social.sports.center.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yield.broker.social.sports.center.repository.RegistrationRepository;

import java.time.LocalDate;


@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    //returns players assigned to a particular court
    public long returnPlayersRegisteredBydateandCourt(int courtId, LocalDate registrationdate) {
        return  registrationRepository.countByCourtIdandReistrationdate(courtId, registrationdate);
    }


    //determines the next nearest available court slot, returns -1 if no courts are available
    public int returnavailablecourt(LocalDate registrationdate){

        if( returnPlayersRegisteredBydateandCourt(1, registrationdate)<4){
            return 1;
        } else if( returnPlayersRegisteredBydateandCourt(2,registrationdate)<4) {
            return 2;
        }else if( returnPlayersRegisteredBydateandCourt(3,registrationdate)<4) {
            return 3;
        }
        return -1;
    }


    //handles assigning new registrations to a court
    public void addNewRegistration(Registration registration) {

            LocalDate todaysdate = LocalDate.now();


            if(registration.getRegistrationdate().isBefore(todaysdate)) {
                System.out.println("Unable to select previous dates");
                return;
            }

            int availablecourtId = returnavailablecourt(registration.getRegistrationdate());

            if(availablecourtId == -1){
                System.out.println("Courts all Booked out for the day");
                return;
            }else {
                registration.setCourtId(availablecourtId);
            }


           registrationRepository.save(registration);
            System.out.println("Assinged to Court: "+registration.getCourtId() );

        if(returnPlayersRegisteredBydateandCourt(registration.getCourtId() ,registration.getRegistrationdate()) ==4) {

            System.out.println("Game is ready to played on Court: "+registration.getCourtId() );
            return;
        }


    }

}
