package com.example.habits_tracker.db.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "reminders")
@Setter
@Getter
@NoArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue(generator = "reminder_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reminder_gen", sequenceName = "reminder_seq", allocationSize = 1)
    private Long id;

    private LocalTime localTime;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private Frequency frequency;

}
