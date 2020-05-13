package io.javamonkey.backend;

import io.javamonkey.backend.model.ERole;
import io.javamonkey.backend.model.Role;
import io.javamonkey.backend.model.User;
import io.javamonkey.backend.repository.RoleRepository;
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
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count() == 0){
            createUser("user", ERole.ROLE_USER);
            createUser("admin", ERole.ROLE_ADMIN);
        }
    }

    private void createUser(String username, ERole eRole){
        Role role = new Role();
        role.setName(eRole);
        roleRepository.save(role);

        User user = new User(username,username+"@demoapp.com", encoder.encode("password") );
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
