package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import biz.casino.roulette.model.GameInputs;

@RestController
public class HelloController {
    @GetMapping("/game")
    public String spinForm(Model model) {
        model.addAttribute("game", new GameInputs());
        return "game";
    }

    @PostMapping("/game")
    public String greetingSubmit(@ModelAttribute GameInputs gameInputs) {
        return "result";
    }
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
