package com.santander.cardspending.resources;

import com.santander.cardspending.domain.Launch;
import com.santander.cardspending.dto.LaunchDTO;
import com.santander.cardspending.services.LaunchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/launches")
@Log4j2
public class LaunchResource {

    @Autowired
    private LaunchService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<?> findbyId(@PathVariable UUID id){
        Launch object = service.find(id);
        return ResponseEntity.ok().body(object);
    }

    @GetMapping()
    public ResponseEntity<List<LaunchDTO>> findAll(){
        List<Launch> list = service.findAll();
        List<LaunchDTO> listDTO = list.stream().map(obj -> new LaunchDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Launch> insert(@RequestBody Launch object){
        object = service.insert(object);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Launch> updateLaunch(
            @PathVariable(value = "id") UUID id,
            @RequestBody Launch launch) {
        return ResponseEntity.ok(service.updateAllLaunch(launch));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Launch> updatePartialLaunch(
            @PathVariable(value = "id") UUID id,
            @RequestBody Launch launch) {
        return ResponseEntity.ok(service.updatePartialLaunch(id,launch));
    }

    @RequestMapping(value={"/{id}"},method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        log.info("Item excluído!!!");
        return ResponseEntity.noContent().build();
    }
}
