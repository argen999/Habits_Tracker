package com.example.habits_tracker.db.entities;

import com.example.habits_tracker.db.entities.enums.ExecutionFrequency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "frequencies")
@Setter
@Getter
@NoArgsConstructor
public class Frequency {

    @Id
    @GeneratedValue(generator = "frequency_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "frequency_gen", sequenceName = "frequency_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExecutionFrequency executionFrequency;

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, REMOVE, PERSIST})
    private List<Reminder> reminders;

    @OneToOne(cascade = {DETACH, MERGE, REFRESH})
    private Habit habit;

}
