package com.example.habits_tracker.db.service;

import com.example.habits_tracker.dto.request.AuthRequest;
import com.example.habits_tracker.dto.request.ResetPasswordRequest;
import com.example.habits_tracker.dto.request.SignUpRequest;
import com.example.habits_tracker.dto.response.AuthResponse;
import com.example.habits_tracker.dto.response.SimpleResponse;

import javax.mail.MessagingException;

public interface UserService {

    AuthResponse singUp(SignUpRequest singUpRequest);

    AuthResponse login(AuthRequest authRequest);

    SimpleResponse forgotPassword(String email) throws MessagingException;

    SimpleResponse resetPassword(int verifyNumber, ResetPasswordRequest request);

}
