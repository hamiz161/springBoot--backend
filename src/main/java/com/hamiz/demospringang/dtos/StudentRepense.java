package com.hamiz.demospringang.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class StudentRepense {
    private Long id;
    private String firstName ;
    private String lastName;

    private String programId;


    private String code;
    private String photo ;
}
