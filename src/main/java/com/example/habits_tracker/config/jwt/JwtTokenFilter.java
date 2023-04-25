package com.example.habits_tracker.config.jwt;


import com.example.habits_tracker.db.entities.User;
import com.example.habits_tracker.db.repository.UserRepository;
import com.example.habits_tracker.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtUtils;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        Optional<String> optionalToken = getTokenFromRequest(request);
        optionalToken.ifPresent(token -> {
            String email = jwtUtils.verifyToken(token);
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new NotFoundException(String.format("User not found with this email: %s ", email)));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    null,
                    null
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        });
        filterChain.doFilter(request, response);
    }

    private Optional<String> getTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            return Optional.of(header.substring("Bearer ".length()));
        }
        return Optional.empty();
    }
}