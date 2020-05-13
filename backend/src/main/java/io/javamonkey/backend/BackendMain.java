package io.javamonkey.backend;

import io.javamonkey.backend.model.Role;
import io.javamonkey.backend.model.User;
import io.javamonkey.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendMain implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendMain.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0){
            createUser("user", Role.USER);
            createUser("admin", Role.ADMIN);
        }
    }

    private void createUser(String username, Role role){

        User user = new User(username,username+"@demoapp.com", encoder.encode("password") );
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
