package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.*;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.SpecialityService;
import sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        // create data for pet type
        PetType savedDogType = null;
        PetType savedCatType = null;
        {
            PetType petType = new PetType();
            petType.setName("Dog");
            savedDogType = petTypeService.save(petType);
        }

        {
            PetType petType = new PetType();
            petType.setName("Cat");
            savedCatType = petTypeService.save(petType);
        }

        Speciality radiologySaved = null;
        Speciality surgerySaved = null;
        Speciality dentinySaved = null;
        {
            Speciality speciality = new Speciality();
            speciality.setDescription("radiology");
            radiologySaved = specialityService.save(speciality);
        }

        {
            Speciality speciality = new Speciality();
            speciality.setDescription("surgery");
            surgerySaved = specialityService.save(speciality);
        }

        {
            Speciality speciality = new Speciality();
            speciality.setDescription("detiny");
            dentinySaved = specialityService.save(speciality);
        }


        System.out.println("loaded pet type");


        {
            Owner owner = new Owner();
            owner.setFirstName("Micheal");
            owner.setLastName("Weston");
            owner.setAddress("123 breaker");
            owner.setCity("miami");
            owner.setTelephone("1212121212");


            Pet pet = new Pet();
            pet.setPetType(savedDogType);
            pet.setOwner(owner);
            pet.setBirthDate(LocalDate.now());
            pet.setName("rosco");

            owner.getPets().add(pet);
            ownerService.save(owner);


        }

        {
            Owner owner = new Owner();
            owner.setFirstName("Fima");
            owner.setLastName("Glanment");
            owner.setAddress("345 ngo quyen");
            owner.setCity("da nang");
            owner.setTelephone("9090909090");

            Pet pet = new Pet();
            pet.setPetType(savedCatType);
            pet.setOwner(owner);
            pet.setBirthDate(LocalDate.now());
            pet.setName("pet cua toan");

            owner.getPets().add(pet);
            ownerService.save(owner);
        }

        System.out.println("loaded owner");

        {
            Vet vet = new Vet();
            vet.setFirstName("Sam");
            vet.setLastName("axe");
            vet.getSpecialities().add(radiologySaved);
            vet.getSpecialities().add(surgerySaved);
            vetService.save(vet);
        }

        {
            Vet vet = new Vet();
            vet.setFirstName("Jetsin");
            vet.setLastName("Poster");
            vet.getSpecialities().add(dentinySaved);
            vet.getSpecialities().add(surgerySaved);
            vetService.save(vet);
        }

        System.out.println("loaded vet");
    }
}
