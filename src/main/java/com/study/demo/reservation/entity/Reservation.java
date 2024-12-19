package com.study.demo.reservation.entity;

import com.study.demo.user.entity.UserInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Size(max = 36)
    @Column(name = "ID", nullable = false, length = 36)
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Size(max = 100)
    @Column(name = "TITLE", length = 100)
    private String title;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @NotNull
    @JoinColumn(name = "USER_ID", nullable = false)
    private String userId;

}