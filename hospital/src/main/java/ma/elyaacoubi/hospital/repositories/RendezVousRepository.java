package ma.elyaacoubi.hospital.repositories;

import ma.elyaacoubi.hospital.entities.Medecin;
import ma.elyaacoubi.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
