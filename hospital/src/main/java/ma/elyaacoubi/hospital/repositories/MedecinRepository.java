package ma.elyaacoubi.hospital.repositories;

import ma.elyaacoubi.hospital.entities.Medecin;
import ma.elyaacoubi.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
