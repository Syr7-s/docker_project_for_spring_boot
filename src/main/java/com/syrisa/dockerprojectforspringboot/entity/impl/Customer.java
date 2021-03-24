package com.syrisa.dockerprojectforspringboot.entity.impl;

import com.syrisa.dockerprojectforspringboot.entity.Entity;
import com.syrisa.dockerprojectforspringboot.utility.gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Entity {
    private long id;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
}
