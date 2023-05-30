package com.example.thenews.service;
import com.example.thenews.entity.User;
import com.example.thenews.exceptions.ResourceNotFoundException;
import com.example.thenews.payload.ApiResponse;
import com.example.thenews.payload.RegisterDTO;
import com.example.thenews.repository.RoleRepository;
import com.example.thenews.repository.UserRepository;
import com.example.thenews.utils.AppConstants;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApiResponse registerUser(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getPrePassword())){
            return new ApiResponse("passwords not match", false);
        }
        if (userRepository.existsByUserName(registerDTO.getUsername())) {
            return new ApiResponse("already registered, please use another username", false);
        }
        User user = new User(
                        registerDTO.getFullName(),
                        registerDTO.getUsername(),
                        passwordEncoder.encode(registerDTO.getPrePassword()),
                true,
                roleRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResourceNotFoundException("role", "role", AppConstants.USER ))

                );
        userRepository.save(user);
        return new ApiResponse("successfully registered", true);
    }

}
