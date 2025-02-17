package com.can.you.doit.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@Entity// TODO
public class PersonEntity {

    private int id;
    private String name;
    private int age;
    private String bloodType;
    private int sugarLevel;
    private BloodPressure bloodPressure;
    private int cholesterolLevel;
    private double weight;
    private int height;
    private double bmi;
    private int heartRate;
    private String exerciseLevel;
    private List<String> medications;
    private List<String> allergies;
    private double sleepHours;
    private List<String> dietaryRestrictions;
    private String smokingStatus;
    private String alcoholConsumption;
    private List<String> familyHistory;

}
