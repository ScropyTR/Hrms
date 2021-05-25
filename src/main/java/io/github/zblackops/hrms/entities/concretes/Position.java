package io.github.zblackops.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="job_positions")
public class Position {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    public Position() {}

    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
