package com.example.user_register_ee.models;

import com.example.user_register_ee.models.enums.Gender;
import com.example.user_register_ee.models.enums.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "users")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="employee")
public class User extends BaseModel{

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "avatar",nullable = false,  columnDefinition = "varchar(256) default 'default.jpg'" )
    private String avatar;

//    @Column(name = "type", insertable = false, updatable = false)
//    @Enumerated(value = EnumType.STRING)
//    private UserType type;

//    @Column(name = "verification_code")
//    private String verificationCode;


//    public boolean isVerified(){
//        return this.verificationCode == null;
//    }




}
