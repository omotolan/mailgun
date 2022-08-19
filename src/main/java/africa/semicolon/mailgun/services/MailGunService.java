package africa.semicolon.mailgun.services;

import africa.semicolon.mailgun.dto.UserDto;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailGunService implements EmailService {


    private final String DOMAIN = System.getenv("DOMAIN");

    private final String PRIVATE_KEY =System.getenv("PRIVATE_KEY");

    @Override
    public String sendSimpleMessage(UserDto userDto) throws UnirestException {
        HttpResponse<String> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN + "/messages")
                .basicAuth("api", PRIVATE_KEY)
                .queryString("from", "ehizman.tutoredafrica@gmail.com")
                .queryString("to", "akinsolakolawole@gmail.com")
                .queryString("subject", "hello")
                .queryString("text", "testing")
                .asString();
        return request.getBody();
    }


}
