package io.github.zblackops.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int languageId;

    @Column(name = "language")
    private String language;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "level")
    private int level;

}
