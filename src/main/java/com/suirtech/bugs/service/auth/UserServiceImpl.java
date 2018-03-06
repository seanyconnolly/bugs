package com.suirtech.bugs.service.auth;

import com.suirtech.bugs.model.auth.User;
import com.suirtech.bugs.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserServiceImpl() {
        logger.info("2 UserServiceImpl");
    }


//	@Override
//	public User findByEmail(String username) {
//		logger.info("WILL GET ALL BUGS" + username);
//		return userRepository.findByEmail(username);
//	}

    @Override
    public User findByUsername(String username) {
        logger.info("WILL GET ALL BUGS" + username);
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        logger.info("got user :: " + user.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user);
    }

}
