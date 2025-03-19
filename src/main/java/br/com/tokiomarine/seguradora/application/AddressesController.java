package br.com.tokiomarine.seguradora.application;

import br.com.tokiomarine.seguradora.domain.exceptions.BadRequestException;
import br.com.tokiomarine.seguradora.domain.exceptions.NotFoundException;
import br.com.tokiomarine.seguradora.domain.services.AddressesService;
import br.com.tokiomarine.seguradora.infrastructure.entities.AddressesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressesController implements IAddressesController{
    @Autowired
    private AddressesService service;

    @Override
    public ResponseEntity<String> create(AddressesEntity addresses) throws Exception {
        try {
            service.create(addresses);
            return ResponseEntity.ok("Addresses created successfully.");
        } catch (Exception e){
            if (e.getClass().equals(BadRequestException.class)){
                return ResponseEntity.badRequest().build();
            } else if (e.getClass().equals(NotFoundException.class)){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<AddressesEntity> read(Long id) throws Exception {
        try {
            return ResponseEntity.ok()
                    .body(service.read(id));
        }catch (Exception e){
            if (e.getClass().equals(NotFoundException.class)){
                return ResponseEntity.notFound().build();
            }

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<Iterable<AddressesEntity>> readAll() throws Exception {
        return ResponseEntity.ok()
                .body(service.readAll());
    }

    @Override
    public ResponseEntity<String> update(Long id, AddressesEntity addresses) throws Exception {

        try {
            service.update(addresses);
            return ResponseEntity.ok("Addresses update successfully.");
        } catch (Exception e){
            if (e.getClass().equals(BadRequestException.class)){
                return ResponseEntity.badRequest().build();
            } else if (e.getClass().equals(NotFoundException.class)) {
                return ResponseEntity.notFound().build();
            }

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<String> delete(Long id) throws Exception {

        try{
            service.delete(id);
            return ResponseEntity.ok("Addresses deleted successfully.");
        }catch (Exception e){
            if (e.getClass().equals(NotFoundException.class)) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
}
