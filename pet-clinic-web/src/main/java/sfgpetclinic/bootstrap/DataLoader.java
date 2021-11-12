package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.VetService;
import sfgpetclinic.services.map.OwnerServiceMap;
import sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        {
            Owner owner = new Owner();
            owner.setId(1L);
            owner.setFirstName("Micheal");
            owner.setLastName("Weston");
            ownerService.save(owner);
        }

        {
            Owner owner = new Owner();
            owner.setId(2L);
            owner.setFirstName("Fima");
            owner.setLastName("Glanment");
            ownerService.save(owner);
        }

        System.out.println("loaded owner");

        {
            Vet vet = new Vet();
            vet.setId(1L);
            vet.setFirstName("Sam");
            vet.setLastName("axe");
            vetService.save(vet);
        }

        {
            Vet vet = new Vet();
            vet.setId(2L);
            vet.setFirstName("Jetsin");
            vet.setLastName("Poster");
            vetService.save(vet);
        }

        System.out.println("loaded vet");
    }
}
