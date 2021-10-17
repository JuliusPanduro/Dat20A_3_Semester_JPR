package dk.kea.paintings.repositories;

import dk.kea.paintings.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Julius Panduro
 */
@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long> {
}
