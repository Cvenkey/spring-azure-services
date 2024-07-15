package com.practice.cloud.azure.model;

import com.practice.cloud.azure.config.ToUpperCase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Pincodes")
public class PincodeData {

    @Column(name = "pin_code")
    private String pincode;
    @Id
    @Column(name="po_name")
    private String poName;
    @Column(name="branch_type")
    private String branchType;
    @Column(name="district")
    private String district;
    @Column(name="region")
    private String region;
    @Column(name="state")
    private String state;
    @Column(name="country")
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="row_id", nullable=false)
    private User user;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
