package com.springexamples.mvc.home;

import com.springexamples.mvc.bo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Home page controller. It has methods which are invoked by user
 * interactions on home page.
 */
@Controller
public class HomepageController {

    @RequestMapping("/")
    public String welcome(Locale locale, Model model) {

        System.out.println("before welcome /");

        return "home";
    }

    @RequestMapping("/test/ajax")
    public String testAjax() {

        System.out.println("before testAjax /test/ajax");

        return "ajax";
    }

    @ResponseBody
    @RequestMapping("/str")
    public String getSimpleStr() {

        System.out.println("before getSimpleStr /str");

        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/user/sample1")
    public User getUser(Model model) {
        System.out.println("before getUser /user");

        User u1 = new User("userNameHere", 24);

        return u1;
    }

    @ResponseBody
    @RequestMapping(value = "/user/sample2")
    public Map<String, Object> getUser2(Model model) {

        System.out.println("before getUser /user2");
        Map<String, Object> map = new HashMap<>();
        User u1 = new User("userNameHere", 24);
        map.put("u1", u1);
        map.put("u2", "undefined");

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/user/sample3", produces = "application/json")
    public List<User> getUser3(Model model) {

        System.out.println("before getUser /user3");


        return getUserList();
    }

    private List<User> getUserList() {
        List<User> lst = new ArrayList<>();
        User user1 = new User();
        user1.setName("aa");
        user1.setAge(10);
        lst.add(user1);
        User user2 = new User();
        user2.setName("bb");
        user2.setAge(33);
        lst.add(user2);
        return lst;
    }

}
