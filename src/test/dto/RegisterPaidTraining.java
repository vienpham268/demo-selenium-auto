package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterPaidTraining {
    String firstName;
    String lastName;
    String email;
    String mobile;
    String country;
    String city;
    String message;
}
