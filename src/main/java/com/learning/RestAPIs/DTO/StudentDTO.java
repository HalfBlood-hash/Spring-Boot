package com.learning.RestAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    Long id;
    String name;
    String email;

}
