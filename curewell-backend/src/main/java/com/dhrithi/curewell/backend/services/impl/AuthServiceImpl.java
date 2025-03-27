package com.dhrithi.curewell.backend.services.impl;


import com.dhrithi.curewell.backend.entity.Role;
import com.dhrithi.curewell.backend.entity.User;
import com.dhrithi.curewell.backend.payload.LoginDto;
import com.dhrithi.curewell.backend.payload.RegisterDto;
import com.dhrithi.curewell.backend.repository.RoleRepository;
import com.dhrithi.curewell.backend.repository.UserRepository;
import com.dhrithi.curewell.backend.security.JwtTokenProvider;
import com.dhrithi.curewell.backend.services.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
//
//    @Override
//    public String register(RegisterDto registerDto) {
//        // Check for existing username or email in the database
//        if (userRepository.existsByUsername(registerDto.getUsername())) {
//            throw new IllegalArgumentException("Username is already taken!");
//        }
//        if (userRepository.existsByEmail(registerDto.getEmail())) {
//            throw new IllegalArgumentException("Email is already taken!");
//        }
//
//        // Create a new user
//        User user = new User();
//        user.setName(registerDto.getName());
//        user.setUsername(registerDto.getUsername());
//        user.setEmail(registerDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//        // Assign role to user
//        Set<Role> roles = new HashSet<>();
//        Role role = roleRepository.findByName(registerDto.getRole())
//                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
//        roles.add(role);
//        user.setRoles(roles);
//
//        // Save the user
//        userRepository.save(user);
//        return "User registered successfully!";
//    }


    @Override
    @Transactional  // Ensure transaction management
    public String register(RegisterDto registerDto) {
        // Check for existing username or email in the database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new IllegalArgumentException("Username is already taken!");
        }
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new IllegalArgumentException("Email is already taken!");
        }

        // Create a new user
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // Assign role to user
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(registerDto.getRole())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        roles.add(role);
        user.setRoles(roles);

        // Save the user
        userRepository.save(user);  // The Role should be automatically managed here if the role was fetched correctly
        return "User registered successfully!";
    }

    @Override
    public String createRole(String name) {
        Role role = new Role();
        role.setName(name);
        role = roleRepository.save(role); // Save the role and retrieve the saved entity
        return "Role '" + role.getName() + "' created successfully with ID: " + role.getId();
    }

    @Override
    public String deleteRole(String name) {
        roleRepository.deleteByName(name);
        return "Role deleted successfully!";
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public String getRoleByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Role not found")).getName();
    }
}
