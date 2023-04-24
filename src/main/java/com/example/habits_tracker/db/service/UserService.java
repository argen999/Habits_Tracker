package com.example.habits_tracker.db.service;

import com.example.habits_tracker.dto.request.AuthRequest;
import com.example.habits_tracker.dto.request.SignUpRequest;
import com.example.habits_tracker.dto.response.AuthResponse;

public interface UserService {

    AuthResponse singUp(SignUpRequest singUpRequest);

    AuthResponse login(AuthRequest authRequest);

}
