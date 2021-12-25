package com.ibrahimtkk.thirdhomework.converter;


import com.ibrahimtkk.thirdhomework.dto.UserDto;
import com.ibrahimtkk.thirdhomework.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);
}
