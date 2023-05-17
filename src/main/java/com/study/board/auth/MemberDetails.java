package com.study.board.auth;

import com.study.board.entity.Users;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
public class MemberDetails implements UserDetails {

    private final Users user;

    public MemberDetails(Users user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

         /* 첫번째 방법
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;*/

        /* 두번째 방법
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(()->{ return user.getRole();});
        return collect;*/

        /* 세번째 방법 */
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new SimpleGrantedAuthority(user.getRole()));

        return collect;

        /* 네번째 방법
        return Collections.singleton(
                new SimpleGrantedAuthority(user.getRole())
        ); */


//        Set<GrantedAuthority> roles = new HashSet<>();
//
//        for(String role : role.split(",")){
//            roles.add(new SimpleGrantedAuthority(role));
//        }
//
//        return roles;


    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
