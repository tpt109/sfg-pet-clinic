package sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Visit;
import sfgpetclinic.services.VisitService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit object) {

        if (object.getPet() == null
                || object.getPet().getVisits() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
