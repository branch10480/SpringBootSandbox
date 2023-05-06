package com.example.demo3;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.model.SampleData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class Demo3Application {
	
	private SampleData[] data = {
		new SampleData("hoge", 20),
		new SampleData("fuga", 21),
		new SampleData("piyo", 22),
	};

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "Hello!";
	}
	
	@GetMapping("/{num}")
	public SampleData search(@PathVariable int num) {
		int n = num < 0 ? 0 : num > data.length ? 0 : num;
		SampleData target = data[n];
		// String msg = "ID=%s. {age: %d}";
		// return String.format(msg, target.getName(), target.getAge());
		
		return target;
	}
	
	@GetMapping("/web")
	public String web(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType(org.springframework.http.MediaType.TEXT_HTML_VALUE);
		String content = "<html><haed>テスト</head><body></body></html>";
		return content;
	}

}
