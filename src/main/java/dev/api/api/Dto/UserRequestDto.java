package dev.api.api.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
}