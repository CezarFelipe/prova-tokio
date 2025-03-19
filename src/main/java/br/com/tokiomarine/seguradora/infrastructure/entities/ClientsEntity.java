package br.com.tokiomarine.seguradora.infrastructure.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "clients", schema = "PUBLIC")
@Component
public class ClientsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String first_name;
    private String last_name;
    private String email;

    public ClientsEntity() {
    }

    public ClientsEntity(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }
}