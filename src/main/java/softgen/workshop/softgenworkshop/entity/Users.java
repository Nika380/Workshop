package softgen.workshop.softgenworkshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nika")
    @SequenceGenerator(name = "nika", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "pasword")
    private String password;
    private String email;
    @Column(name = "create_date")
    private Date createDate = new Date() ;
    @Column(name = "active")
    private boolean active;
}
