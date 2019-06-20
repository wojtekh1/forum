package com.handel.forum.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

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
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;


    @Column(name = "Email")
//    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "Is_Active")
    private Integer isActive;

    @Column(name = "Image")
    private String imageLink;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Users_User_Type",
            joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "User_Type_Id"))
    @NotEmpty(message = "*Please choose at least one role!")
    private List<UserType> roles;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Post post;
}
