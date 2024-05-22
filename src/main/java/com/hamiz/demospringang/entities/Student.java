package com.hamiz.demospringang.entities;

import com.fasterxml.jackson.core.JsonToken;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table

public class Student {

    @Id

    private String id;
    private String firstName ;
    private String lastName;

    private String programId;

    @Column (unique = true)
    private String code;
    private String photo ;



}
