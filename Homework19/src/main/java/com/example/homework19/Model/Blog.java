package com.example.homework19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title is required")
    @Column(columnDefinition = "varchar(20)")
    private String title;

    @Size(max = 300,message = "The maximum length is 300")
    @Column(columnDefinition = "varchar(300)")
    private String body;

    @Column(columnDefinition = "varchar(20) not null check(category='health' or category='education' or category='programming')")
    private String category;

    @AssertFalse(message = "Publishing must be false")
    @Column(columnDefinition = "boolean default false")
    private Boolean isPublished = false;
}
