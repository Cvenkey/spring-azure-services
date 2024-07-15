package com.practice.cloud.azure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User{
    @Id
    @Column(name = "row_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rowId;
    @Column(name = "user_name")
    private String  userName;
    @Column(unique = true, length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @LastModifiedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @OneToMany(mappedBy="user")
    private Set<PincodeData> pincodes;
}
