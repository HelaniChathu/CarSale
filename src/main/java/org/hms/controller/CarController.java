package org.hms.controller;

import org.hms.orm.model.Car;
import org.hms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by helani on 10/1/14.
 */
@Controller
@RequestMapping(value = "car")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addCar(ModelMap model) {
        model.addAttribute("car", new Car());
        model.addAttribute("msg", "Hi all");
        return "addcar";
    }

    @RequestMapping(value = "addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car, Model model) {
        carService.save(car);
        model.addAttribute("car", car);
        model.addAttribute("msg", "saved");
        return "viewcar";
    }
//
//    @RequestMapping(value = "list", method = RequestMethod.GET)
//    public String addCar(Model model) {
//        model.addAttribute("carList", carService.carListWithAllDetails());
//        return "carlist";
//    }
//
//    @RequestMapping(value = "view", method = RequestMethod.GET)
//    public String viewCarDetails(@RequestParam(value = "id", required = true) Long id, Model model) {
//        Car car = carService.findById(id);
//        model.addAttribute("car", car);
//        return "viewcar";
//    }
}
