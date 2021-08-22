package Controller;

import Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("Show");
        modelAndView.addObject("List",customerService.findAll());
        return modelAndView;
    }
}
