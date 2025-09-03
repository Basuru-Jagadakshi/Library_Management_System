package lk.zerocode.library.api.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lk.zerocode.library.api.DTO.Request.AuthRequest;
import lk.zerocode.library.api.Security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@AllArgsConstructor
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    Logger log = LoggerFactory.getLogger(AuthController.class);

//    @Transactional(readOnly = true)
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//
//        log.info(authentication.toString());
//
//        UserDetails userDetails = new User(request.getUsername(), "", authentication.getAuthorities());
//        String token = jwtUtil.generateToken(userDetails);
//
//        Object auth = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//
//        //return ResponseEntity.ok(Collections.singletonMap("token", token));
//        return ResponseEntity.ok(authentication.getAuthorities(), token));
//    }

    @Transactional(readOnly = true)
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthRequest request) {

        // Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        log.info(authentication.toString());

        // Load authenticated user details
        //UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        UserDetails userDetails = new User(request.getUsername(), "", authentication.getAuthorities());
        // Generate JWT token
        String token = jwtUtil.generateToken(userDetails);

        // Extract roles from authentication
        List<String> roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        // Build response
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("roles", roles);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Server doesn't delete token; client should remove it
        return ResponseEntity.ok("Logged out successfully");
    }
}
