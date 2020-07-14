package ru.officelibrary.officelibrary.dto.response;

import lombok.*;
import ru.officelibrary.officelibrary.common.UserType;

import java.sql.Date;


@Getter
@Setter
//@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {

    private int userID;
    private String name;
    private String lastName;
    private String patronymicName;
    private Date birthDate;
    private UserType userType;
}
