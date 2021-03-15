package h8.chikey.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientservice")

public class ClientService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int clientServiceID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ServiceId")
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ClientID")
    private Client client;

    @Column(name = "Comment")
    private String comment;


    @Override
    public String toString() {
        return "ClientService{" +
                "clientServiceID=" + clientServiceID +
                ", service=" + service +
                ", client=" + client +
                ", comment='" + comment + '\'' +
                '}';
    }
}
