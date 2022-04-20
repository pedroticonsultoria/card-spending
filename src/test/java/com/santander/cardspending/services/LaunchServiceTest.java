package com.santander.cardspending.services;

import com.santander.cardspending.domain.Launch;
import com.santander.cardspending.exceptions.ObjectNotFoundException;
import com.santander.cardspending.repositories.LaunchRepository;
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
class LaunchServiceTest{

    @InjectMocks
    private LaunchService launchService;

    @Mock
    private LaunchRepository launchRepository;

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
        when(launchRepository.findById(any(UUID.class))).thenReturn(Optional.of(launch));
        assertNotNull(launchService.find(UUID.randomUUID()));
    }

    @Test
    void findThrowExceptionTest(){
        when(launchRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(ObjectNotFoundException.class,()->launchService.find(UUID.randomUUID()));
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
        when(launchRepository.save(any(Launch.class))).thenReturn(launch);
        assertNotNull(launchService.insert(launch));
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
        when(launchRepository.findAll()).thenReturn(List.of(launch));
        assertNotNull(launchService.findAll());
    }



}