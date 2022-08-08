package africa.semicolon.mailgun.dto;

import africa.semicolon.mailgun.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;



    public static UserDto packDto(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
