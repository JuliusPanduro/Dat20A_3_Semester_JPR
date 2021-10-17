package dk.kea.paintings.repositories;

import dk.kea.paintings.models.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Julius Panduro
 */
public interface PaintingRepository extends JpaRepository<Painting, Long> {
    List<Painting> findPaintingsByArtistAndYear(String artistName, int year);

    @Query(value = "SELECT * FROM paintings WHERE price> ?", nativeQuery = true)
    List<Painting> findPaintingsAboveCertainPrice(double price);
}
