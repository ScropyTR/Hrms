package io.github.zblackops.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.zblackops.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
@Table(name = "employers")
@PrimaryKeyJoinColumn(name="user_id")
@Entity
public class Employer extends User {

    @Column(name = "company_name", nullable = true)
    private String companyName;

    @Column(name = "web_site", nullable = true)
    private String webSite;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

}
