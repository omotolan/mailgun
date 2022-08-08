package africa.semicolon.mailgun.services;

import africa.semicolon.mailgun.dto.AccountCreationRequest;
import africa.semicolon.mailgun.dto.UserDto;
import africa.semicolon.mailgun.exceptions.EmailAlreadyExistException;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface UserService {
    UserDto createUserAccount(AccountCreationRequest accountCreationRequest) throws EmailAlreadyExistException, EmailAlreadyExistException, UnirestException;
}
