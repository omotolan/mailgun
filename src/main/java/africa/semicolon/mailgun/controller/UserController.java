package africa.semicolon.mailgun.controller;

import africa.semicolon.mailgun.dto.AccountCreationRequest;
import africa.semicolon.mailgun.dto.UserDto;
import africa.semicolon.mailgun.exceptions.EmailAlreadyExistException;
import africa.semicolon.mailgun.services.UserService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
//@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/reg")
    public ResponseEntity<?> createUser(@RequestBody AccountCreationRequest accountCreationRequest) {
        try {
          //  log.info("Account Creation Request ==> {}", accountCreationRequest);
            UserDto userDto = userService.createUserAccount(accountCreationRequest);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("user created successfully")
                    .data(userDto)
                    .build();
           // log.info("Returning response");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (EmailAlreadyExistException e) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("fail")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(e.getStatusCode()));
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }
}
