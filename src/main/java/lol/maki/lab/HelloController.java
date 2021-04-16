package lol.maki.lab;

import java.time.Duration;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final AtomicInteger id = new AtomicInteger(0);

	private static long initializedAt = System.currentTimeMillis();

	@GetMapping(path = "hello")
	public Map<String, ?> hello(@RequestParam(name = "name", defaultValue = "World") String name) {
		final Map<String, Object> response = new TreeMap<>();
		response.put("id", this.id.incrementAndGet());
		response.put("message", String.format("Hello %s!", name));
		response.put("uptime", Duration.ofMillis(System.currentTimeMillis() - initializedAt));
		return response;
	}
}
