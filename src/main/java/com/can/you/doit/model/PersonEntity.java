package com.can.you.doit.model;

import com.can.you.doit.utils.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    @Column(name = "blood_type")
    private String bloodType;
    @Column(name = "sugar_level")
    private int sugarLevel;

    @Embedded
    private BloodPressure bloodPressure;
    @Column(name = "cholesterol_level")
    private int cholesterolLevel;
    private double weight;
    private int height;
    private double bmi;
    @Column(name = "heart_rate")
    private int heartRate;
    @Column(name = "exercise_level")
    private String exerciseLevel;

    @Column(name = "sleep_hours")
    private double sleepHours;

    @Column(name = "smoking_status")
    private String smokingStatus;
    @Column(name = "alcohol_consumption")
    private String alcoholConsumption;
    @Convert(converter = StringListConverter.class)
    @Column(name = "dietary_restrictions")
    private List<String> dietaryRestrictions;
    @Convert(converter = StringListConverter.class)
    @Column(name = "medications")
    private List<String> medications;
    @Convert(converter = StringListConverter.class)
    @Column(name = "allergies")
    private List<String> allergies;
    @Convert(converter = StringListConverter.class)
    @Column(name = "family_history")
    private List<String> familyHistory;
    @Column(name = "image_url")
    private String imageUrl;

}
