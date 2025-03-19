package br.com.tokiomarine.seguradora.application;

import br.com.tokiomarine.seguradora.domain.exceptions.BadRequestException;
import br.com.tokiomarine.seguradora.domain.exceptions.NotFoundException;
import br.com.tokiomarine.seguradora.domain.services.ClientsService;
import br.com.tokiomarine.seguradora.infrastructure.entities.ClientsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsController implements IClientsController{
    @Autowired
    private ClientsService service;

    @Override
    public ResponseEntity<String> create(ClientsEntity clients) throws Exception {
        try {
            service.create(clients);
            return ResponseEntity.ok("Client created successfully.");
        } catch (Exception e){
            if (e.getClass().equals(BadRequestException.class)){
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<ClientsEntity> read(Long id) throws Exception {
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
    public ResponseEntity<Iterable<ClientsEntity>> readAll() throws Exception {
        return ResponseEntity.ok()
                .body(service.readAll());
    }

    @Override
    public ResponseEntity<String> update(Long id, ClientsEntity clients) throws Exception {

        try {
            service.update(clients);
            return ResponseEntity.ok("Client update successfully.");
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
            return ResponseEntity.ok("Client deleted successfully.");
        }catch (Exception e){
            if (e.getClass().equals(NotFoundException.class)) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
}
