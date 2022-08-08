package africa.semicolon.mailgun.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_sequence")
    private Long id;

    private String firstName;

    private String lastName;
    private String email;
}
