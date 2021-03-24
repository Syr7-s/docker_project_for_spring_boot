package com.syrisa.dockerprojectforspringboot.service;

import com.syrisa.dockerprojectforspringboot.entity.Entity;

public interface EntityService<T extends Entity> {
    T create(T t);


}
