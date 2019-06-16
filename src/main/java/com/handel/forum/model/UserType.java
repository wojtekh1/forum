package com.handel.forum.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Type_Id")
    private Integer userTypeId;

    @Column(name = "Type")
    private String userType;
}
