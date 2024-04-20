package com.mastico.ToDoList.Controllers.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import com.mastico.ToDoList.Models.Lista;

public class DozerMapper {
	
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<Lista> list, Class<D> class1){
        List<D> destinationObjects = new ArrayList<>();
        for (Lista o : list) {
            destinationObjects.add((D) mapper.map(o, class1));
        }
        return destinationObjects;
    }
}
