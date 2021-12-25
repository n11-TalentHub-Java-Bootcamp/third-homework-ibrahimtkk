package com.ibrahimtkk.thirdhomework.converter;


import com.ibrahimtkk.thirdhomework.dto.ProductCommentDto;
import com.ibrahimtkk.thirdhomework.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    ProductComment toProductComment(ProductCommentDto productCommentDto);

    ProductCommentDto toDto(ProductComment productComment);
}
