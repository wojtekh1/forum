package com.handel.forum.model;

import lombok.*;
import javax.validation.constraints.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Forumusers")
public class ForumUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private Integer userId;

    @Column(name = "Password")
    @Size(min = 5, message = "Hasło musi mieć przynajmniej 5 znaków")
    private String password;


    @Column(name = "Email")
    @Email(message = "Wprowadź poprawny adres email")
    @NotEmpty
    private String email;

    @Column(name = "Is_Active")
    private Integer isActive;

    @Column(name = "Image")
    private String imageLink;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Users_User_Type",
            joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "User_Type_Id"))
    @NotEmpty(message = "Wybierz uprawnienia")
    private List<UserType> roles;
}
