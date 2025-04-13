package ma.elyaacoubi.hospital;

import ma.elyaacoubi.hospital.entities.*;
import ma.elyaacoubi.hospital.repositories.ConsultationRepository;
import ma.elyaacoubi.hospital.repositories.MedecinRepository;
import ma.elyaacoubi.hospital.repositories.PatientRepository;
import ma.elyaacoubi.hospital.repositories.RendezVousRepository;
import ma.elyaacoubi.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}


	@Bean
	CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,RendezVousRepository rendezVousRepository,MedecinRepository medecinRepository) {

		return args -> {

			Stream.of("Mohamed","hassan","najat")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("ayman","Mouad","yasmine")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail("ayman@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveMedecin(medecin);

					});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient2 = patientRepository.findByNom("Mohamed");

			Medecin medecin = medecinRepository.findByNom("Mouad");

			RendezVous rendezVous= new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous saveRDV = hospitalService.saveRDV(rendezVous);

			System.out.println(saveRDV.getId());

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRapport("rapport de la consultation");
			hospitalService.saveConsultation(consultation);
		};

	}
}
