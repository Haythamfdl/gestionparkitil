package com.sid.gestionparkitil.gestionparkitil.Util;

import org.springframework.beans.BeanUtils;

public class FromDtoToEntity {

    private FromDtoToEntity() {
    }

    public static <T> T attribut(Object dto, Object entity) {
        BeanUtils.copyProperties(dto, entity);
        return (T) entity;
    }
}
