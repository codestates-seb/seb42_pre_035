package com.team035.pre_project35.audit;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass                                   //다른 엔티티들이 Auditable를 상속할경우 이 필드를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)      //Auditing 기능 포함
public abstract class Auditable {
    //JPA Auditiong 기능

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
