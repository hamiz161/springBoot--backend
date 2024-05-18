package com.hamiz.demospringang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
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
