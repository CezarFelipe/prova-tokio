package br.com.tokiomarine.seguradora.application;

import br.com.tokiomarine.seguradora.infrastructure.entities.ClientsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Class that provides a rest service for the Clients functionality.
 *
 **/
@Api(value="Clients endpoint")
@RequestMapping(value = "/clients")
public interface IClientsController {

    /**
     *
     * Method that registers clients.
     *
     * @param clients Metadata with client information.
     *
     **/
    @ApiOperation(value = "Create customer record.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Client created successfully."),
            @ApiResponse(code = 400, message = "Incorrect data format"),
    }
    )
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> create( @RequestBody ClientsEntity clients) throws Exception;

    /**
     *
     * Method that queries the client through the id.
     *
     * @param id Numeric value identifying the customer record.
     *
     **/
    @ApiOperation(value = "Read client data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Client successfully located."),
            @ApiResponse(code = 404, message = "Client not located."),
    }
    )

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClientsEntity> read(
            @PathVariable("id") Long id) throws Exception;

    /**
     *
     * Method that queries the all clients.
     *
     *
     **/
    @ApiOperation(value = "Read all clients data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Clients successfully located."),
    }
    )

    @GetMapping(value = "/all")
    ResponseEntity<Iterable<ClientsEntity>> readAll() throws Exception;

    /**
     *
     * Method that update client data.
     *
     * @param id Numeric value identifying the customer record.
     * @param clients Metadata with client information.
     *
     **/
    @ApiOperation(value = "Update client data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Client data updated successfully."),
            @ApiResponse(code = 404, message = "Client not located."),
            @ApiResponse(code = 400, message = "Incorrect data format")
    }
    )
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> update(
            @PathVariable("id") Long id, @RequestBody ClientsEntity clients) throws Exception;

    /**
     *
     * Method that delete client data.
     *
     * @param id Numeric value identifying the customer record.
     *
     **/
    @ApiOperation(value = "Delete client data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Client data deleted successfully."),
            @ApiResponse(code = 404, message = "Client not located."),
    }
    )
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> delete(
            @PathVariable("id") Long id) throws Exception;

}
