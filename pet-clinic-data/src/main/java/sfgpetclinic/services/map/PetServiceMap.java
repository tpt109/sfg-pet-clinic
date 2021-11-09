package sfgpetclinic.services.map;

import sfgpetclinic.model.Pet;
import sfgpetclinic.services.CRUDService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CRUDService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
