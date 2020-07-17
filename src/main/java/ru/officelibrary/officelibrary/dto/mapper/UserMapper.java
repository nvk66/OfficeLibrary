package ru.officelibrary.officelibrary.dto.mapper;

import org.mapstruct.Mapper;
import ru.officelibrary.officelibrary.dto.request.UserDtoRequest;
import ru.officelibrary.officelibrary.entity.User;

@Mapper
public interface UserMapper {
    UserDtoRequest userToUserDto(User user);

    User userDtoToUser(UserDtoRequest userDto);
}
