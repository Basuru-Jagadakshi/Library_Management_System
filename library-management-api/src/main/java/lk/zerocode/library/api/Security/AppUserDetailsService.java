package lk.zerocode.library.api.Security;

import lk.zerocode.library.api.Model.Member;
import lk.zerocode.library.api.Repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    Logger log = LoggerFactory.getLogger(AppUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("authentication user with username [{}]", username);

        Member user = memberRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("No user found with username  [" + username + "]")
        );
        System.out.println("user " + user.getAuthorities().size());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities(user.getAuthorities().stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                        .toList())
                .build();
    }
}
