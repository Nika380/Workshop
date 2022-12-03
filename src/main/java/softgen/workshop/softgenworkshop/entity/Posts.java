package softgen.workshop.softgenworkshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Posts {
    @Id
    private Integer id;
    private String body;
    private String title;

    private int userId;
    private LocalDate createDate;
}
