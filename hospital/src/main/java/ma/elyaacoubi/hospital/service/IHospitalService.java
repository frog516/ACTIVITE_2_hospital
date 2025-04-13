package ma.elyaacoubi.hospital.service;

import ma.elyaacoubi.hospital.entities.Consultation;
import ma.elyaacoubi.hospital.entities.Medecin;
import ma.elyaacoubi.hospital.entities.Patient;
import ma.elyaacoubi.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
