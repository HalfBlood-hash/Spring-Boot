package com.learning.RestAPIs.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class AddStudentRequestDto {

    @NonNull
    @NotBlank
    @Size(min= 2,max= 10,message = "Min size 2 and Max size 10")
     private String name;
    @Email

    @NonNull
    @NotBlank
   private String email;
}
