package io.github.zblackops.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
@Table(name = "cities")
@Entity
public class City {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "city_name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisements;

}
