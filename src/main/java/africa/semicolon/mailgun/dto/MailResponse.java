package africa.semicolon.mailgun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Setter
@Getter
public class MailResponse {
    private boolean isSuccessful;

}
