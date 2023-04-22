package com.example.habits_tracker.db.entities;

import com.example.habits_tracker.db.entities.enums.ExecutionFrequency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "habits")
@Setter
@Getter
@NoArgsConstructor
public class Habit {

    @Id
    @GeneratedValue(generator = "habit_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "habit_gen", sequenceName = "habit_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    private int goal;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToOne(cascade = {DETACH, MERGE, REFRESH, REMOVE, PERSIST})
    private Frequency frequency;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private User user;

    @OneToOne(cascade = {DETACH, MERGE, REFRESH, REMOVE})
    private Tracking tracking;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH, REMOVE}, mappedBy = "habits")
    private List<Achievement> achievements;

}
