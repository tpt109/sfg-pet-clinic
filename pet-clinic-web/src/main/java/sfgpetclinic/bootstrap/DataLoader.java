package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.PetType;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.VetService;

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
        {
            PetType petType = new PetType();
            petType.setName("Dog");
            petTypeService.save(petType);
        }

        {
            PetType petType = new PetType();
            petType.setName("Cat");
            petTypeService.save(petType);
        }

        System.out.println("loaded pet type");


        {
            Owner owner = new Owner();
            owner.setFirstName("Micheal");
            owner.setLastName("Weston");
            ownerService.save(owner);
        }

        {
            Owner owner = new Owner();
            owner.setFirstName("Fima");
            owner.setLastName("Glanment");
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
