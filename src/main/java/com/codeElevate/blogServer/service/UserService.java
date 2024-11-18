package com.codeElevate.blogServer.service;

import com.codeElevate.blogServer.Dto.UserDTO;
import com.codeElevate.blogServer.entity.User;  // Correct import
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String addUser(UserDTO userDTO);
}