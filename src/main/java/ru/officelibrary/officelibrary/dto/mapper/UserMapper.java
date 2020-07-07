package ru.officelibrary.officelibrary.dto.mapper;

import org.mapstruct.Mapper;
import ru.officelibrary.officelibrary.dto.request.UserDtoRequest;
import ru.officelibrary.officelibrary.dto.response.UserDtoResponse;
import ru.officelibrary.officelibrary.model.User;

@Mapper
public interface UserMapper {
    UserDtoResponse userToUserDto(User user);

    User userDtoToUser(UserDtoRequest userDto);
}
