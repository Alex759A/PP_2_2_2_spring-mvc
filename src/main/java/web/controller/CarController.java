package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.serviceCar.CarService;
import web.serviceCar.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService = new CarServiceImpl();

        @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
//http://localhost:8088/cars/?count=4...1..2..
    @GetMapping(value = "/")

    public String carMapping(@RequestParam(value = "count", defaultValue = "5", required = false) long count, ModelMap model) {
    model.addAttribute("carList", carService.getCarsList(count));

        return "cars";
    }


    @GetMapping()
    public String carsList(Model model) {
        model.addAttribute("carList", carService.getCars());
        return "cars";
    }

}
