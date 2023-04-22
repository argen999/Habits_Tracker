package com.example.habits_tracker.db.entities;

import com.example.habits_tracker.db.entities.enums.Ranks;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@Table(name = "achievements")
@Setter
@Getter
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(generator = "achievement_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "achievement_gen", sequenceName = "achievement_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Ranks ranks;

    private String description;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private User user;

    @ManyToMany(cascade = {DETACH, MERGE, REFRESH})
    @JoinTable(name = "habits_achievements",
            joinColumns = @JoinColumn(name = "habit_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private List<Habit> habits;

}

