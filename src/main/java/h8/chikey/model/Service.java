package h8.chikey.model;

import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "service")

public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int serviceId;

    @NonNull
    @Column(name = "Title")
    private String title;

    @NonNull
    @Column(name = "Cost")
    private double cost;

    @NonNull
    @Column(name = "DurationInSecond")
    private int durationInSecond;

    @Column(name = "Description")
    private String description;

    @Column(name = "Discount")
    private double discount;

    @Column(name = "MainImagePath")
    private String mainImagePath;

    @OneToMany(mappedBy = "service")
    Set<ClientService> setService;

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", durationInSecond=" + durationInSecond +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }

}
