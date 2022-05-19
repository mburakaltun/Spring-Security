package mburakaltun.springSecurityProject.DAO;

import mburakaltun.springSecurityProject.Model.ApplicationUser;
import mburakaltun.springSecurityProject.Security.ApplicationUserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("InMemory")
public class InMemoryApplicationUserDAOImpl implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    public InMemoryApplicationUserDAOImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> loadUserByUsername(String username) {
        return getApplicationUsers().
                stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return new ArrayList<>(
                Arrays.asList(
                        new ApplicationUser(
                                "mburakaltun",
                                passwordEncoder.encode("password"),
                                ApplicationUserRole.STUDENT.getGrantedAuthorities(),
                                true,
                                true,
                                true,
                                true
                        ),
                        new ApplicationUser(
                                "begumsevde",
                                passwordEncoder.encode("password"),
                                ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                                true,
                                true,
                                true,
                                true
                        ),
                        new ApplicationUser(
                                "edenhazard",
                                passwordEncoder.encode("password"),
                                ApplicationUserRole.ADMIN_TRAINEE.getGrantedAuthorities(),
                                true,
                                true,
                                true,
                                true
                        )
                )
        );
    }
}
