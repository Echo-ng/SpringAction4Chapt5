package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spittr.bean.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

/**
 * @Author: Echo
 * @Date: 2019/1/11 14:25
 * @Description:
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Spittles(@RequestParam("max") long max, @RequestParam("count") int count){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spittles");
        modelAndView.addObject(spittleRepository.findSpittles(max,count));
        return modelAndView;
    }

    @RequestMapping(value = "/{spittleId}",method = RequestMethod.GET)
    public ModelAndView showSpittle(@PathVariable("spittleId") long spittleId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spittle");
        modelAndView.addObject(spittleRepository.findOne(spittleId));
        return modelAndView;
    }


}
