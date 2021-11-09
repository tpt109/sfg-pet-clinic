package sfgpetclinic.services.map;

import sfgpetclinic.model.Owner;
import sfgpetclinic.services.CRUDService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CRUDService<Owner, Long> {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
