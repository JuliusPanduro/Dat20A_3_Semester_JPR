package dk.kea.poelse.repositories;

import dk.kea.poelse.models.Poelse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Julius Panduro
 */
public interface PoelseRepository extends JpaRepository<Poelse, Long> {
}
