package lol.maki.lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(path = "hello")
	public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
