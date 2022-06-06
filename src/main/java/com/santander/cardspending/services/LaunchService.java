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

    public List<Launch> findAll() {
        return repo.findAll();
    }

    public Launch find(UUID id) {
        Optional<Launch> object = repo.findById(id);
        if (object.isEmpty()) {
            throw new ObjectNotFoundException("Lançamento não encontrado! Id:" + id + ", Tipo: " + Launch.class.getName());
        }
        return object.orElse(null);
    }

    public Launch insert(Launch object) {
        object.setId(null);
        object.setRegisterDate(LocalDateTime.now());
        return repo.save(object);
    }

    public Launch updateAllLaunch(Launch launch) {
        return repo.save(launch);
    }

    private Launch getLaunchByLaunchID(UUID id) {
        return repo.findByLaunch(id).orElseThrow(() -> new RuntimeException());
    }


    public Launch updatePartialLaunch(UUID uuid, Launch launchRequest) {
        find(uuid);
        Launch launch = getLaunchByLaunchID(uuid);

        if (launchRequest.getName() != null) {
            launch.setName(launchRequest.getName());
        }
        if (launchRequest.getDescription() != null) {
            launch.setDescription(launchRequest.getDescription());
        }
        if (launchRequest.getRegisterDate() != null) {
            launch.setRegisterDate(launchRequest.getRegisterDate());
        }
        if (launchRequest.getValue() != null) {
            launch.setValue(launchRequest.getValue());
        }
        if (launchRequest.getTags() != null) {
            launch.setTags(launchRequest.getTags());
        }

        return repo.save(launch);
    }

    public void delete(UUID id) {
        find(id);
        repo.deleteById(id);
    }

//    public Page<Launch> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
//        return repo.findAll(pageRequest);
//    }
}
