package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "gender")

public class Gender {

    @Id
    @NonNull
    @Column(name = "Code",nullable = false)
    private char codeGender;

    @Column(name = "Name")
    private String name;


    @OneToMany(mappedBy = "gender")
    Set<Client> setGender;


    @Override
    public String toString() {
        return name;
    }
}
