package ma.elyaacoubi.hospital.service;

import jakarta.transaction.Transactional;
import ma.elyaacoubi.hospital.entities.Consultation;
import ma.elyaacoubi.hospital.entities.Medecin;
import ma.elyaacoubi.hospital.entities.Patient;
import ma.elyaacoubi.hospital.entities.RendezVous;
import ma.elyaacoubi.hospital.repositories.ConsultationRepository;
import ma.elyaacoubi.hospital.repositories.MedecinRepository;
import ma.elyaacoubi.hospital.repositories.PatientRepository;
import ma.elyaacoubi.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {


    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }


    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        //uuid genere des chiane de caractere
        rendezVous.setId(UUID.randomUUID().toString());

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
