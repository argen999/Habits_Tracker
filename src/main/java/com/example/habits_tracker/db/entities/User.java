package com.example.habits_tracker.db.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String link;

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, REMOVE}, mappedBy = "user")
    private List<Habit> habits;

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, REMOVE}, mappedBy = "user")
    private List<Achievement> achievements;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void addHabit(Habit habit) {
        if (habits == null) habits = new ArrayList<>();
        else habits.add(habit);
    }

}
