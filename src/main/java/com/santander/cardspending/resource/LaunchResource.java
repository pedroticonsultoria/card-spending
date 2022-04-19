package com.santander.cardspending.resource;

import com.santander.cardspending.domain.Launch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/launches")
public class LaunchResource {

    @RequestMapping(method=RequestMethod.GET)
    public List<Launch> listar(){

        Launch launch1 = new Launch(1,"Pedro","Almoço",null,10.0,"Tag 1 almoço");
        Launch launch2 = new Launch(2,"Nicole","Jantar",null,20.0,"Tag 2 jantar");

        List<Launch> lista = new ArrayList<>();
        lista.add(launch1);
        lista.add(launch2);


        return lista;
    }
}
