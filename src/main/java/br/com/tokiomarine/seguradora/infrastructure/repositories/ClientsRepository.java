package br.com.tokiomarine.seguradora.infrastructure.repositories;

import br.com.tokiomarine.seguradora.infrastructure.entities.ClientsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<ClientsEntity, Long> {

}
