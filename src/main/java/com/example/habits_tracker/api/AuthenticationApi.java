package com.example.habits_tracker.api;

import com.example.habits_tracker.db.service.UserService;
import com.example.habits_tracker.dto.request.AuthRequest;
import com.example.habits_tracker.dto.request.SingUpRequest;
import com.example.habits_tracker.dto.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final UserService userService;

    @PostMapping("/signup")
    public AuthResponse singUp(@RequestBody @Valid SingUpRequest request) {
        return userService.singUp(request);
    }

    @PostMapping("/login")
    public AuthResponse singUp(@RequestBody @Valid AuthRequest request) {
        return userService.login(request);
    }
}
