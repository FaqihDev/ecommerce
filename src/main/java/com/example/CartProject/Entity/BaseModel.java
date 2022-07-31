package com.example.CartProject.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseModel extends AuditableBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String description;

    @Column(name = "is_deleted",length = 1)
    private int isDeleted;
}
