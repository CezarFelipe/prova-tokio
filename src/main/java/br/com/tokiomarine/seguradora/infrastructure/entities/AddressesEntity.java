package br.com.tokiomarine.seguradora.infrastructure.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "addresses", schema = "PUBLIC")
@Component
public class AddressesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Long id_client;
    private String address;
    private String number;
    private String complement;
    private String postal_code;
    private String city;
    private String state;
    private String country;

    public AddressesEntity() {
    }

    public Long getId() {
        return id;
    }

    public Long getId_client() {
        return id_client;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}