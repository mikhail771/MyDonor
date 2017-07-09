package ua.donordp.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ua.donordp.model.Role;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

/**
 * Created by kots on 08.06.2017.
 */
@Service
public class SecurityService {
//    public static final String ROLE_KEY = "userRole";
//
//    private Role currentRole(){
//        HttpSession currentSession = currentSession();
//        Role role = (Role) currentSession.getAttribute(ROLE_KEY);
//        return role == null ? Role.GUEST : role;
//    }
//
//    public void setRole(Role role){
//        HttpSession currentSession = currentSession();
//        currentSession.setAttribute(ROLE_KEY, role);
//    }
//
//    private HttpSession currentSession(){
//        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        return attrs.getRequest().getSession();
//    }
//
//    public <T> ResponseEntity<T> operateWithRole(Role role, SecuredOperation<T> operation){
//        if(currentRole().equals(role)){
//            return operation.operate();
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((T) "Fuck you!!!!!");
//        }
//    }
//
//    public static interface SecuredOperation<T>{
//        public ResponseEntity<T> operate();
//    }
}
