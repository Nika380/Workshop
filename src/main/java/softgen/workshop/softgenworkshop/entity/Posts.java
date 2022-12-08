package softgen.workshop.softgenworkshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@SequenceGenerator(name = "postIdGenerator", sequenceName = "posts_id_seq", allocationSize = 1)
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postIdGenerator")
    private Integer id;
    @Column(name = "body")
    private String body;
    @Column(name = "title")
    private String title;
    @Column(name = "user_id")

    private int userId;
    @Column(name = "create_date")
    private Date createDate = new Date();

    @Column(name = "deleted")
    private boolean deleted = false;
}
