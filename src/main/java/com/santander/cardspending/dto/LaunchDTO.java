package com.santander.cardspending.dto;

import com.santander.cardspending.domain.Launch;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaunchDTO implements Serializable {

    private static final long serialVersionUID = -156443103097722965L;

    private String name;
    private String description;
    private LocalDateTime registerDate;
    private BigDecimal value;
    private String tags;

    public LaunchDTO(Launch launch){
        name= launch.getName();
        description = launch.getDescription();
        registerDate = launch.getRegisterDate();
        value = launch.getValue();
        tags = launch.getTags();
    }




}
