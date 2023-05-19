package com.study.board.auth;

import com.study.board.entity.Users;
import com.study.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username){

        Users user = userRepository.findByUsername(username);
        if(user != null){
            return new MemberDetails(user);
        }

        return null;
    }

//    public Users main(Integer id){
//        return userRepository.findById(id).get();
//    }


}
