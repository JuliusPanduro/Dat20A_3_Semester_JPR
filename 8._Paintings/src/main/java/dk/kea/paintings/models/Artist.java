package dk.kea.paintings.models;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Julius Panduro
 */
@Data //Used instead of generating getters and setters
@Table(name = "artists")
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String primaryStyle;

    //change size of nationality
    @Column(length = 50) //sets the varchar to 50
    private String nationality;


    @Column
    private Date birthDate;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Gender gender;

    //LAZY = fetch when needed
    //EAGER = fetch immediately
    @ManyToOne
    @Nullable
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;


}
