package br.com.tokiomarine.seguradora.domain.services;

import br.com.tokiomarine.seguradora.domain.exceptions.BadRequestException;
import br.com.tokiomarine.seguradora.domain.exceptions.NotFoundException;
import br.com.tokiomarine.seguradora.infrastructure.entities.ClientsEntity;
import br.com.tokiomarine.seguradora.infrastructure.repositories.ClientsRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * Classe que fornece um serviço da funcionalidade cliente
 *
 **/

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository repository;

    public void create (ClientsEntity entity) throws Exception{
        validateFieldClient(entity);
        repository.save(entity);
    }
    public ClientsEntity read (Long id) throws Exception {
        Optional<ClientsEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException("client not found");
        }
        return entity.get();
    }
    public void update (ClientsEntity entity) throws Exception {

        validateFieldClient(entity);
        read(entity.getId());
        repository.save(entity);

    }
    public void delete (Long id) throws Exception {
        if (id == null) {
            throw new BadRequestException("required field: id");
        }
        read(id);
        repository.deleteById(id);
    }
    public Iterable<ClientsEntity> readAll ()  {
        return repository.findAll();
    }
    private void validateFieldClient(ClientsEntity entity) throws Exception{
        if (entity == null){
            throw new BadRequestException("required field");
        } else if (entity.getEmail() == null ) {
            throw new BadRequestException("required field: email");
        } else if (entity.getFirst_name() == null) {
            throw new BadRequestException("required field: first_name");
        } else if (entity.getId() == null) {
            throw new BadRequestException("required field: id");
        }
    }
}
