package africa.semicolon.mailgun.services;

import africa.semicolon.mailgun.dto.AccountCreationRequest;
import africa.semicolon.mailgun.dto.UserDto;
import africa.semicolon.mailgun.exceptions.EmailAlreadyExistException;
import africa.semicolon.mailgun.model.User;
import africa.semicolon.mailgun.repository.UserRepository;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private EmailService emailService;

    @Override
    public UserDto createUserAccount(AccountCreationRequest accountCreationRequest) throws EmailAlreadyExistException, UnirestException {

        validate(accountCreationRequest);
        User user = User.builder()
                .firstName(accountCreationRequest.getFirstName())
                .lastName(accountCreationRequest.getLastName())
                .email(accountCreationRequest.getEmail())
                .build();

        User savedUser = userRepository.save(user);

        emailService.sendSimpleMessage(UserDto.packDto(savedUser));

        return UserDto.packDto(savedUser);
    }

    private void validate(AccountCreationRequest accountCreationRequest) throws EmailAlreadyExistException {
        User user = userRepository.findUserByEmail(accountCreationRequest.getEmail()).orElse(null);
        if (user != null) {
            throw new EmailAlreadyExistException("user email already exists", 400);
        }
    }

}