package dk.kea.paintings.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Julius Panduro
 */
@Data
@Table(name = "galleries")
@Entity
@NoArgsConstructor
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long galleryID;

    @Column
    private String owner;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int squareFeet;

    //LAZY = fetch when needed
    //EAGER = fetch immediately
    @JsonIgnore
    @OneToMany(mappedBy = "gallery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Artist> artist;


}
