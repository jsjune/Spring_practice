package com.sparta.board.service;

import com.sparta.board.domain.User;
import com.sparta.board.repository.UserRepository;
import com.sparta.board.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final UserRepository userRepository;

    public String home(Model model, UserDetailsImpl userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + userDetails.getUsername()));
        model.addAttribute("username", user.getUsername());
        return "index";
    }
}