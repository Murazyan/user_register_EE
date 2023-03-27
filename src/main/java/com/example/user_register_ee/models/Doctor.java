package com.example.user_register_ee.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{


    @OneToMany(mappedBy = "doctor")
    private List<Interval> intervals;

    @OneToMany(mappedBy = "doctor")
    private List<Request> requests;

}
