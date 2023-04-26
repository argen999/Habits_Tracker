package com.example.habits_tracker.api;

import com.example.habits_tracker.db.service.UserService;
import com.example.habits_tracker.dto.request.AuthRequest;
import com.example.habits_tracker.dto.request.ResetPasswordRequest;
import com.example.habits_tracker.dto.request.SignUpRequest;
import com.example.habits_tracker.dto.response.AuthResponse;
import com.example.habits_tracker.dto.response.SimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final UserService userService;

    @PostMapping("/signup")
    public AuthResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return userService.singUp(request);
    }

    @PostMapping("/login")
    public AuthResponse signIn(@RequestBody @Valid AuthRequest request) {
        return userService.login(request);
    }

    @PostMapping("/forgot")
    public SimpleResponse forgotPassword(@RequestParam String email) throws MessagingException {
        return userService.forgotPassword(email);
    }

    @PutMapping("/")
    public SimpleResponse resetPassword(@RequestParam int verifyNumber, @RequestBody ResetPasswordRequest request) throws MessagingException {
        return userService.resetPassword(verifyNumber, request);
    }

}
