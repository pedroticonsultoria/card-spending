package com.santander.cardspending.resource;

import com.santander.cardspending.domain.Launch;
import com.santander.cardspending.exceptions.ObjectNotFoundException;
import com.santander.cardspending.services.LaunchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LaunchResourceTest {

    @Mock
    private LaunchService launchService;

    @InjectMocks
    private LaunchResource launchResource;

    @Test
    void findTest(){
        var launch = Launch.builder()
                .id(UUID.randomUUID())
                .name("Pedro Henrique")
                .description("Restaurante Manati")
                .registerDate(LocalDateTime.now())
                .value(new BigDecimal("35.00"))
                .tags("Alimentação")
                .build();
        when(launchService.find(any(UUID.class))).thenReturn(launch);
        assertNotNull(launchResource.find(UUID.randomUUID()));
    }


    @Test
    void insertTest(){



        var launch = Launch.builder()
                .id(UUID.randomUUID())
                .name("Pedro Henrique")
                .description("Restaurante Manati")
                .registerDate(LocalDateTime.now())
                .value(new BigDecimal("35.00"))
                .tags("Alimentação")
                .build();
        when(launchService.insert(any(Launch.class))).thenReturn(launch);
        assertNotNull(launchResource.insert(launch));
    }

    @Test
    void findAllTest(){
        var launch = Launch.builder()
                .id(UUID.randomUUID())
                .name("Pedro Henrique")
                .description("Restaurante Manati")
                .registerDate(LocalDateTime.now())
                .value(new BigDecimal("35.00"))
                .tags("Alimentação")
                .build();
        when(launchService.findAll()).thenReturn(List.of(launch));
        assertNotNull(launchResource.findAll());
    }

}
