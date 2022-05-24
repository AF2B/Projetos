package com.af2b.backend.services;

import java.util.Optional;

import com.af2b.backend.Repository.RequestRepository;
import com.af2b.backend.domain.Request;
import com.af2b.backend.services.Exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request find(Integer id) {
        Optional<Request> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Request.class.getName()));
    }
}
