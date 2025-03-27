package com.dhrithi.curewell.backend.controller;


import com.dhrithi.curewell.backend.entity.Role;
import com.dhrithi.curewell.backend.payload.LoginDto;
import com.dhrithi.curewell.backend.payload.RegisterDto;
import com.dhrithi.curewell.backend.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        var data = authService.login(loginDto);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto registerDto) {
        var data = authService.register(registerDto);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/role")
    public ResponseEntity<String> createRole(@RequestBody String name) {
        var data = authService.createRole(name);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        var data = authService.getAllRoles();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<String> getRoleByName(@PathVariable("name") String name) {
        var data = authService.getRoleByName(name);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/role/{name}")
    public ResponseEntity<String> deleteRole(@PathVariable("name") String name) {
        var data = authService.deleteRole(name);
        return ResponseEntity.ok(data);
    }

}