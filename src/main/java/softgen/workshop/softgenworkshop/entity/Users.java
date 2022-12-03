package softgen.workshop.softgenworkshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Users {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String email;
    private LocalDate createDate;
    private boolean active;
}
