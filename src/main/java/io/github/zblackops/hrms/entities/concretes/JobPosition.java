package io.github.zblackops.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int jobPositionId;

    @Column(name = "name", nullable = true)
    private String name;

    @OneToMany(mappedBy = "jobPosition")
    List<JobAdvertisement> jobAdvertisements;
}
