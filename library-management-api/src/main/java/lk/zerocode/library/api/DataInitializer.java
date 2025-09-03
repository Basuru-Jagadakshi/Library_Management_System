package lk.zerocode.library.api;

import lk.zerocode.library.api.Model.Authority;
import lk.zerocode.library.api.Model.Member;
import lk.zerocode.library.api.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Only create if not exists
        if (memberRepository.findByUserName("admin").isEmpty()) {
            Member adminUser = new Member();
            adminUser.setMemberName("Amal Perera");
            adminUser.setEmail("amalperera@gmail.com");
            adminUser.setUserName("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setEnabled(true);

            Authority adminAuthority = new Authority();
            adminAuthority.setAuthority("ROLE_ADMIN");
            adminAuthority.setUser(adminUser);

            adminUser.setAuthorities(Collections.singletonList(adminAuthority));
            memberRepository.save(adminUser);
        }

        // Similar for user role
        if (memberRepository.findByUserName("user").isEmpty()) {
            Member user = new Member();
            user.setMemberName("Basuru Jagadakshi");
            user.setEmail("basurujagadakshi@gmail.com");
            user.setUserName("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setEnabled(true);

            Authority userAuthority = new Authority();
            userAuthority.setAuthority("ROLE_USER");
            userAuthority.setUser(user);

            user.setAuthorities(Collections.singletonList(userAuthority));
            memberRepository.save(user);
        }
    }
}
