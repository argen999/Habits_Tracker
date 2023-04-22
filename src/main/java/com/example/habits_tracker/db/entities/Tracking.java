package com.example.habits_tracker.db.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;


@Entity
@Table(name = "trackings")
@Setter
@Getter
@NoArgsConstructor
public class Tracking {

    @Id
    @GeneratedValue(generator = "tracking_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tracking_gen", sequenceName = "tracking_seq", allocationSize = 1)
    private Long id;

    private int countingTheNumberOfCompletedDays;

    private int habitMeasurement;

    private LocalDate calendar;

    @OneToOne(cascade = {DETACH, MERGE, REFRESH})
    private Habit habit;

}
