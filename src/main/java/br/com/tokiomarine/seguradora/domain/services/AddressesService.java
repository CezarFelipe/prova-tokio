package br.com.tokiomarine.seguradora.domain.services;

import br.com.tokiomarine.seguradora.domain.exceptions.BadRequestException;
import br.com.tokiomarine.seguradora.domain.exceptions.NotFoundException;
import br.com.tokiomarine.seguradora.infrastructure.entities.AddressesEntity;
import br.com.tokiomarine.seguradora.infrastructure.repositories.AddressesRepository;
import br.com.tokiomarine.seguradora.infrastructure.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressesService {

    @Autowired
    private AddressesRepository repository;

    @Autowired
    private ClientsRepository clientsRepository;

    public void create (AddressesEntity entity) throws Exception{
        validateFieldClient(entity);
        validationClient(entity.getId_client());
        repository.save(entity);
    }

    public AddressesEntity read (Long id) throws Exception {
        Optional<AddressesEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException("address not found");
        }
        return entity.get();
    }


    public void update (AddressesEntity entity) throws Exception {

        validateFieldClient(entity);
        validationClient(entity.getId_client());
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

    public Iterable<AddressesEntity> readAll ()  {
        return repository.findAll();
    }

    private void validateFieldClient(AddressesEntity entity) throws Exception{
        if (entity == null){
            throw new BadRequestException("required field");
        }
        else if (entity.getId() == null ) {
            throw new BadRequestException("required field: id");
        }
        else if (entity.getId_client() == null ) {
            throw new BadRequestException("required field: id_client");
        } else if (entity.getAddress() == null) {
            throw new BadRequestException("required field: address");
        } else if (entity.getNumber() == null) {
            throw new BadRequestException("required field: number");
        } else if (entity.getComplement() == null) {
            throw new BadRequestException("required field: complement");
        }
    }
    private void validationClient(long id){
        if (!clientsRepository.existsById(id)){
            throw new NotFoundException("client id not found");
        }
    }
}
