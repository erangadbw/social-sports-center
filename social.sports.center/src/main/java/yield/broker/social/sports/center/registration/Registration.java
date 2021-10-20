package yield.broker.social.sports.center.registration;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @Column(name= "registrationId")
    @GeneratedValue
    private Long registrationId;
    private int courtId;

    private LocalDate registrationdate;


    @Override
    public String toString() {
        return "Registration{" +
                "courtID=" + courtId +
                ", registrationdate=" + registrationdate +
                '}';
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public int getCourtId() {
        return courtId;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }
}
