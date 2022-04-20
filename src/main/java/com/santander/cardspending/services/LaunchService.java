package com.santander.cardspending.services;

import com.santander.cardspending.domain.Launch;
import com.santander.cardspending.exceptions.ObjectNotFoundException;
import com.santander.cardspending.repositories.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LaunchService {

    @Autowired
    private LaunchRepository repo;

    public Launch find(UUID id){
        Optional<Launch> object = repo.findById(id);
        if (object.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encntrado! Id:" + id
            + ", Tipo: " + Launch.class.getName());
        }
        return object.orElse(null);
    }

    public Launch insert(Launch object){
        object.setId(null);
        object.setRegisterDate(LocalDateTime.now());
        return repo.save(object);
    }

    public List<Launch> findAll() {
        return repo.findAll();
    }
}
