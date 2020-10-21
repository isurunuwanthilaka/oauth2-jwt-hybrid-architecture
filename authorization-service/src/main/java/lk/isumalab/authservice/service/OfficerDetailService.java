package lk.isumalab.authservice.service;

import lk.isumalab.authservice.model.TransportDto;
import lk.isumalab.authservice.model.User;
import lk.isumalab.authservice.repository.UserDetailRepository;
import lk.isumalab.authservice.utils.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OfficerDetailService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public OfficerDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    public User loadUserByUsername(String name) {

        Optional<User> optionalUser = userDetailRepository.findByUsername(name);

        return optionalUser.orElse(null);

    }

    public TransportDto save(User user) {
        Optional<User> optionalUser = userDetailRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            user.setId(existingUser.getId());
            log.warn("Updating existing user. username: {}", user.getUsername());
            return new TransportDto(new ApiStatus(HttpStatus.NOT_FOUND, "Duplicate Record", "User Name not found in DB"), false);
        }
        return new TransportDto(new ApiStatus(HttpStatus.OK, "Success"), true);

    }

}
