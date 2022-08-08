package africa.semicolon.mailgun.controller;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse {
    private String status;
    private String message;
    private Object data;
    private int result;
}
