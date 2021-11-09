package sfgpetclinic.services;

import sfgpetclinic.model.Owner;

public interface OwnerService extends CRUDService<Owner, Long> {
    Owner findByLastName(String lastName);
}
