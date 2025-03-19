package br.com.tokiomarine.seguradora.application;

import br.com.tokiomarine.seguradora.infrastructure.entities.AddressesEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Class that provides a rest service for the Addresses functionality.
 *
 **/
@Api(value="Addresses endpoint")
@RequestMapping(value = "/addresses")
public interface IAddressesController {

    /**
     *
     * Method that registers addresses.
     *
     * @param addresses Metadata with address information.
     *
     **/
    @ApiOperation(value = "Create addresses record.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Address created successfully."),
            @ApiResponse(code = 400, message = "Incorrect data format"),
    }
    )
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> create( @RequestBody AddressesEntity addresses) throws Exception;

    /**
     *
     * Method that queries the address through the id.
     *
     * @param id Numeric value identifying the address record.
     *
     **/
    @ApiOperation(value = "Read address data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Address successfully located."),
            @ApiResponse(code = 404, message = "Address not located."),
    }
    )

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AddressesEntity> read(
            @PathVariable("id") Long id) throws Exception;

    /**
     *
     * Method that queries the all addresses.
     *
     *
     **/
    @ApiOperation(value = "Read all addresses data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Addresses successfully located."),
    }
    )

    @GetMapping(value = "/all")
    ResponseEntity<Iterable<AddressesEntity>> readAll() throws Exception;

    /**
     *
     * Method that update address data.
     *
     * @param id Numeric value identifying the address record.
     * @param addresses Metadata with address information.
     *
     **/
    @ApiOperation(value = "Update address data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Address data updated successfully."),
            @ApiResponse(code = 404, message = "Address not located."),
            @ApiResponse(code = 400, message = "Incorrect data format")
    }
    )
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> update(
            @PathVariable("id") Long id, @RequestBody AddressesEntity addresses) throws Exception;

    /**
     *
     * Method that delete address data.
     *
     * @param id Numeric value identifying the address record.
     *
     **/
    @ApiOperation(value = "Delete address data.", response = Iterable.class)
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Address data deleted successfully."),
            @ApiResponse(code = 404, message = "Address not located."),
    }
    )
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> delete(
            @PathVariable("id") Long id) throws Exception;

}
