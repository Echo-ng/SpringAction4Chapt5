package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.bean.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

/**
 * @Author: Echo
 * @Date: 2019/1/14 16:50
 * @Description:
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    private SpitterRepository spitterRepository;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegisterForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid Spitter spitter, Errors errors){
        spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
