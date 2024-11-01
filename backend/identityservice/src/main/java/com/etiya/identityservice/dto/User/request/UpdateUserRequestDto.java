package com.etiya.identityservice.dto.user.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequestDto {
    private int id;
    @NotBlank
    @NotNull
    private int userName;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private Integer titleId;
    @NotBlank
    private String email;
    @PositiveOrZero
    private Integer wrongAttempts;
    private boolean isLocked;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    public Integer getUserId() {
        return id;
    }
}