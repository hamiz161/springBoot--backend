package com.hamiz.demospringang.entities;

import com.fasterxml.jackson.core.JsonToken;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity


public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String firstName ;
    private String lastName;

    private String programId;


    private String code;
    private String photo ;

}
