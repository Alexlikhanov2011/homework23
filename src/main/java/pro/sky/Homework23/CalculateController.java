package pro.sky.Homework23;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/calculator")
public class CalculateController {
    private final CalculateService service;
    public CalculateController(CalculateService service){
        this.service=service;
    }
@GetMapping("/")
    public String hello(){
return "Добро пожаловать в калькулятор!";
}
    @GetMapping("/plus")
public String plus(@RequestParam(required = false) Integer num1, @RequestParam (required = false) Integer num2){
    if (num1==null||num2==null){
        return "Один из параметров не задан!";
    }
        return num1 + " + " + num2 + " = " + service.plus(num1,num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam (required = false) Integer num2){
        if (num1==null||num2==null){
            return "Один из параметров не задан!";
        }
        return num1 + " - " + num2 + " = " + service.minus(num1,num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam (required = false) Integer num2){
        if (num1==null||num2==null){
            return "Один из параметров не задан!";
        }
        return num1 + " * " + num2 + " = " + service.multiply(num1,num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam (required = false) Integer num2){
        if (num1==null||num2==null){
            return "Один из параметров не задан!";
        }
        if(num2==0)
            return "Делить на 0 нельзя!";
        return num1 + " / " + num2 + " = " + service.divide(num1,num2);
    }
}
