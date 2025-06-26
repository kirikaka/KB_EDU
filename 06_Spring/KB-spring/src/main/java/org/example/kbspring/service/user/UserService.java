package org.example.kbspring.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.user.User;
import org.example.kbspring.repository.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void save(User user){

        System.out.println("save user : " + user.getRole());
        user.setRole(user.getRole());


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
