package ma.elyaacoubi.hospital.repositories;

import ma.elyaacoubi.hospital.entities.Consultation;
import ma.elyaacoubi.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
