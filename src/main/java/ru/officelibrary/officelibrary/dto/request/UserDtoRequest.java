package ru.officelibrary.officelibrary.dto.request;

import lombok.*;
import ru.officelibrary.officelibrary.model.UserType;

import java.sql.Date;

@Getter
@Setter
//@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRequest {
    private String name;
    private String lastName;
    private String patronymicName;
    private Date birthDate;
    private UserType userType;
}
