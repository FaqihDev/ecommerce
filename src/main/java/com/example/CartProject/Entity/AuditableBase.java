package com.example.CartProject.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditableBase {

    @CreatedBy
    @Column(name = "created_By")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_Date")
    private String createdDate;

    @LastModifiedBy
    @Column(name = "updated_By")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;


}
