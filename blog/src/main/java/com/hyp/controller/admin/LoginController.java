package com.hyp.controller.admin;

import com.hyp.pojo.User;
import com.hyp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName blog
 * @ClassName LoginController
 * @create 2020-07-10 16:50
 * @Author by hyp
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    //登录首页
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    //登录验证用户
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user=userService.checkUser(username,password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }else{
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    //注销退出用户
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
