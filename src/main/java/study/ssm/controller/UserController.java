package study.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.ssm.entity.User;
import study.ssm.service.impl.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session, Model model){
        if(userService.checkUser(user)){
            session.setAttribute("username", user.getUsername());
        }else{
            model.addAttribute("actionState", "登陆失败,请重试!");
        }
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        model.addAttribute("actionState", "注销成功!");
        return "index";
    }

}
