package com.study.board.controller;


import com.study.board.auth.MemberDetailsService;
import com.study.board.entity.Users;
import com.study.board.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MemberDetailsService memberDetailsService;

    @GetMapping("/join")
    public String join(Model model) {
        return "join";
    }

    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }

    @PostMapping("/joinProc")
    public String joinProc(Users user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        user.setRole("ROLE_USER");
        userRepository.save(user);

        return "redirect:/"; // main으로 이동
    }

//    @PostMapping(value = "/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
//
//        new SecurityContextLogoutHandler().logout(request, response,
//                SecurityContextHolder.getContext().getAuthentication());
//
//        model.addAttribute("message","로그아웃 완료");
//        model.addAttribute("searchUrl","/");
//
//        return "redirect:message";
//
//    }
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if(authentication != null){
//            new SecurityContextLogoutHandler().logout(request,response,authentication);
//        }
//
//        return "main";
//    }

}
