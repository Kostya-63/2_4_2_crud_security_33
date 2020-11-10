package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;
import web.model.User;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return user;
    }
}







/*
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthorities(user));

        private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
            String[] userRoles = user.getRoles().stream()
                    .map(Role::getRole).toArray(String[]::new);
            Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
            return authorities;
        }*/