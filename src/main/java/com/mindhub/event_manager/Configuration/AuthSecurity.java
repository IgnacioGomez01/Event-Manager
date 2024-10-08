package com.mindhub.event_manager.Configuration;
import com.mindhub.event_manager.models.Customer;
import com.mindhub.event_manager.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthSecurity extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(username -> {
            Customer user = customerRepository.findByEmail(username);
            if(user != null){
                return new User(user.getEmail(),user.getPassword(), AuthorityUtils.createAuthorityList(user.getRol().toString()));
            }else {
                throw new UsernameNotFoundException("Email invalid");
            }
        });
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}