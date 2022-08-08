package africa.semicolon.mailgun.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AccountCreationRequest {
    private String firstName;
    private String lastName;
    private String email;
}
