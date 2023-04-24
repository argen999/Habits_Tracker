package com.example.habits_tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String token;

}
