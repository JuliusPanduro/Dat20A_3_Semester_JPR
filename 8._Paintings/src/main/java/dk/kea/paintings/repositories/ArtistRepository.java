package dk.kea.paintings.repositories;

import dk.kea.paintings.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Julius Panduro
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    public Artist findByName(String name);
}
