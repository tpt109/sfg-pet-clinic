package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Pet;
import sfgpetclinic.model.PetType;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
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
            vetService.save(vet);
        }

        {
            Vet vet = new Vet();
            vet.setFirstName("Jetsin");
            vet.setLastName("Poster");
            vetService.save(vet);
        }

        System.out.println("loaded vet");
    }
}
