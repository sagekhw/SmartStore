package store.test.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Setter
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "email", nullable = false, unique=true)
    private String email;

    private String username;

    @Column(name = "mobile_phone_number", nullable = false, unique=true)
    private Long mobilePhoneNumber;

    @ManyToOne
    private Company company;
}
