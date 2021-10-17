package dk.kea.paintings.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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



}
