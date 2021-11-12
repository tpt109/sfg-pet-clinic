package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
