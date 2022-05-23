package com.af2b.backend.services;

import java.util.Optional;

import com.af2b.backend.Repository.ClientRepository;
import com.af2b.backend.domain.Client;
import com.af2b.backend.services.Exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client find(Integer id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! id: " + id + ", Tipo: " + Client.class.getName()
        ));
        }
}