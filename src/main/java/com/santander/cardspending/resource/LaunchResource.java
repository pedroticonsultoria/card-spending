package com.santander.cardspending.resource;

import com.santander.cardspending.domain.Launch;
import com.santander.cardspending.services.LaunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping(value="/launches")
public class LaunchResource {

    @Autowired
    private LaunchService service;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable UUID id){

        Launch object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> find(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Launch> insert(@RequestBody Launch object){
        object = service.insert(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).body(object);
    }
}
