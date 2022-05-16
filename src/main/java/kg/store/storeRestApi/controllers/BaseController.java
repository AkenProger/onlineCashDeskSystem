package kg.store.storeRestApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/main")
public class BaseController {
    @GetMapping("")
    public String getHello() {
        return "Hello from Java Spring";
    }
}
