package HandMaven.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julius Panduro
 */
@RestController
public class AboutController {

    @GetMapping("/about")
    public String aboutThisProject(){
        return "About";
    }
}
