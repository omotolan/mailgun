package africa.semicolon.mailgun.services;

import africa.semicolon.mailgun.dto.UserDto;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface EmailService {
    String sendSimpleMessage(UserDto userDto) throws UnirestException;
}
