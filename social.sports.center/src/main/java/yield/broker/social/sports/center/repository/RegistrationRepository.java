package yield.broker.social.sports.center.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import yield.broker.social.sports.center.registration.Registration;

import java.time.LocalDate;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {



    //Counts how many players registered for a court on a specific day
    @Query("Select Count(r) FROM Registration r WHERE (r.courtId =?1 AND r.registrationdate =?2) ")
    long countByCourtIdandReistrationdate(int CourtId, LocalDate registrationdate );



}
