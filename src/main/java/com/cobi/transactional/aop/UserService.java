package com.cobi.transactional.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void createUserListWithTrans(){
        for (int i = 0; i < 10; i++) {
            createUser(i);
        }
//        throw new RuntimeException();
    }

    public void createUserListWithoutTrans(){
        for (int i = 0; i < 10; i++) {
            createUser(i);
        }
//        throw new RuntimeException();
    }
    
    @Transactional
    public User createUser(int index){
        User user = User.builder()
                .name("testname::"+index)
                .email("testemail::"+index)
                .build();
        
        userRepository.save(user);
        return user;
    }
    
    @Transactional
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
