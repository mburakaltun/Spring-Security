package mburakaltun.springSecurityProject.Security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String applicationUserPermission;

    ApplicationUserPermission(String applicationUserPermission) {
        this.applicationUserPermission = applicationUserPermission;
    }

    public String getApplicationUserPermission() {
        return applicationUserPermission;
    }

}
