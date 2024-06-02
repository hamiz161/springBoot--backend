package com.hamiz.demospringang.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class StudentRequest {
    private String firstName ;
    private String lastName;

    private String programId;

    private String code;
    private String photo ;
}
