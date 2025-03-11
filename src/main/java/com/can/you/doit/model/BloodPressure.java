package com.can.you.doit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class BloodPressure {
    @JsonProperty("systolic")
    private int systolic;
    @JsonProperty("diastolic")
    private int diastolic;

}
