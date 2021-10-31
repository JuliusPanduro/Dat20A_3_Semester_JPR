package dk.kea.paintings.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Julius Panduro
 */
@Data
@Table(name = "paintings")
@Entity
@NoArgsConstructor
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @ApiModelProperty(notes = "name of the artist")
    private String artist;
    @Column
    private double price;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private int year;

    /*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "paintings_artists",
            joinColumns = {
                    @JoinColumn(name = "paintings_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "artists_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            }
    )
    private List<Artist> artists;

     */

}
