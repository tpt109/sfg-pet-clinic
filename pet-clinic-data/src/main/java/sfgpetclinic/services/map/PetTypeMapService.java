package sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sfgpetclinic.model.PetType;
import sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object.getId(), object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
