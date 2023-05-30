package com.example.thenews.payload;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    @NotNull(message="fullName cannot be blank")
    private String fullName;
    @NotNull(message = "password cannot be blank")
    private String prePassword;
    @NotNull(message = "password cannot be blank")
    private String Password;
    @NotNull(message = "username cannot be blank")
    private  String username;

}
