package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    UUID id = UUID.randomUUID();

    @CreatedDate
    LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    LocalDateTime lastModifiedDate = LocalDateTime.now();

}
