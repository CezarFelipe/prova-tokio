package br.com.tokiomarine.seguradora.infrastructure.repositories;

import br.com.tokiomarine.seguradora.infrastructure.entities.AddressesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends CrudRepository<AddressesEntity, Long> {

}
