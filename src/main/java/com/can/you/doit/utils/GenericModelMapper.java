package com.can.you.doit.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericModelMapper {

    private final ModelMapper modelMapper;

    public GenericModelMapper() {
        this.modelMapper = new ModelMapper();
    }

    public <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public <S, D> List<D> mapList(List<S> source, Class<D> destinationType) {
        return source.stream()
                .map(item -> modelMapper.map(item, destinationType))
                .collect(Collectors.toList());
    }
}
