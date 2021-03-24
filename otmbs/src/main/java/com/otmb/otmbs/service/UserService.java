package com.otmb.otmbs.service;

import com.otmb.otmbs.entity.Role;
import com.otmb.otmbs.entity.User;
import com.otmb.otmbs.repository.RoleRepository;
import com.otmb.otmbs.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;


    private RoleRepository roleRepository;


    public UserService( UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    /**
     * Create a new role along with users
     */

    @Transactional
    public ResponseEntity<Object> addUser(User user) {

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setMobile(user.getMobile());
        newUser.setEmail(user.getEmail());

        newUser.setRole(user.getRole());
        User savedUsers = userRepository.save(newUser);
        if (userRepository.findById(savedUsers.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

    /**
     * Delete a specified role given the id
     */
    public ResponseEntity<Object> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            if (userRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
}
