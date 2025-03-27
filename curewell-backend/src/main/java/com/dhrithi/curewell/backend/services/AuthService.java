package com.dhrithi.curewell.backend.services;

import com.dhrithi.curewell.backend.entity.Role;
import com.dhrithi.curewell.backend.payload.LoginDto;
import com.dhrithi.curewell.backend.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(String name);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);

}