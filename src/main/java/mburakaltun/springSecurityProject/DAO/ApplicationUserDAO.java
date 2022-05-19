package mburakaltun.springSecurityProject.DAO;

import mburakaltun.springSecurityProject.Model.ApplicationUser;
import java.util.Optional;

public interface ApplicationUserDAO {
    Optional<ApplicationUser> loadUserByUsername(String username);
}
