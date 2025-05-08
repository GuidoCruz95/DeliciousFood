package com.coderoad.deliciousfood.services;

import com.coderoad.deliciousfood.models.User;
import com.coderoad.deliciousfood.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing user-related operations such as registration, retrieval by email,
 * retrieval by Facebook ID, and fetching all users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructs the UserService with the required repository.
     *
     * @param userRepository the repository for User entities
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers a new user in the system.
     *
     * @param user the user to be registered
     * @return the saved User entity
     */
    public User register(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves a user by their email address.
     *
     * @param email the email address of the user
     * @return an Optional containing the User if found, otherwise empty
     */
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Retrieves a user by their Facebook ID.
     *
     * @param facebookId the Facebook ID of the user
     * @return an Optional containing the User if found, otherwise empty
     */
    public Optional<User> getByFacebookId(String facebookId) {
        return userRepository.findByFacebookId(facebookId);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all User entities
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }
}