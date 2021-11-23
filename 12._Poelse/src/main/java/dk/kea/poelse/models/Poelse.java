package dk.kea.poelse.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Julius Panduro
 */
@Data
@Entity
@NoArgsConstructor
public class Poelse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public String name;

    @Column
    public String type;

    @Column
    public double price;

    @Column
    public double length;

    @Column
    public double weight;

}
