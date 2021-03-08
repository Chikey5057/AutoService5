package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NonNull
    private int clientId;

    @NonNull
    @Column(name = "FirstName")
    private String firstName;

    @NonNull
    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Patronymic")
    private String patronymic;

    @Column(name = "Birthday")
    private Date birthday;

    @NonNull
    @Column(name = "RegistrationDate")
    private Date registrationDate;

    @Column(name = "Email")
    private String email;

    @NonNull
    @Column(name = "Phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenderCode")
    private Gender gender;

    @Column(name = "PhotoPath")
    private String photoPath;

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
