package com.Spring.platzimarket.persistence.mapper;

import com.Spring.platzimarket.domain.Category;
import com.Spring.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.crypto.spec.PSource;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
//    hace el mapeo para pasar los datos a la db convertir
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

//    esto hace un mapeo inverso , para una convercion externa
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
