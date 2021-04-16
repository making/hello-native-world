package lol.maki.lab;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final AtomicInteger count = new AtomicInteger(0);

	private static OffsetDateTime initializedAt = OffsetDateTime.now();

	@GetMapping(path = "hello")
	public Map<String, ?> hello(@RequestParam(name = "name", defaultValue = "World") String name) {
		final Map<String, Object> response = new LinkedHashMap<>();
		response.put("message", String.format("Hello %s!", name));
		response.put("count", this.count.incrementAndGet());
		response.put("initializedAt", initializedAt);
		return response;
	}
}
