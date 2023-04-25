package com.example.habits_tracker.db.service.serviceimpl;

import com.example.habits_tracker.config.jwt.JwtTokenProvider;
import com.example.habits_tracker.db.entities.User;
import com.example.habits_tracker.db.repository.UserRepository;
import com.example.habits_tracker.db.service.UserService;
import com.example.habits_tracker.dto.request.AuthRequest;
import com.example.habits_tracker.dto.request.SignUpRequest;
import com.example.habits_tracker.dto.response.AuthResponse;
import com.example.habits_tracker.exceptions.BadCredentialsException;
import com.example.habits_tracker.exceptions.BadRequestException;
import com.example.habits_tracker.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse singUp(SignUpRequest singUpRequest) {
        if (!userRepository.existsByEmail(singUpRequest.getEmail())) {
            User user = new User();

            user.setFirstname(singUpRequest.getName());
            user.setLastname(singUpRequest.getLastname());
            user.setEmail(singUpRequest.getEmail());
            user.setPassword(passwordEncoder.encode(singUpRequest.getPassword()));
            user.setLink(singUpRequest.getLink());

            userRepository.save(user);

            return new AuthResponse(user.getId(),
                    user.getFirstname(),
                    user.getLastname(),
                    user.getEmail(),
                    jwtTokenProvider.generateToken(user.getEmail()));

        } else {
            throw new BadRequestException(String.format("This %s already exists!", singUpRequest.getEmail()));
        }
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(
                () -> new NotFoundException(String.format("User with %s not found!", authRequest.getEmail()))
        );

        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {

            return new AuthResponse(user.getId(),
                    user.getUsername(),
                    user.getLastname(),
                    user.getEmail(),
                    jwtTokenProvider.generateToken(user.getEmail()));

        } else {
            throw new BadCredentialsException("This password already exists!");
        }
    }

}
