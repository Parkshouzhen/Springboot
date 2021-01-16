package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("159") // URL맵핑 localhost:8000/159
	public String hello(Model model) {
		model.addAttribute("data", "159쥔장이다");
		return "helloWorld"; // helloWorld.html 을 웹페이지에 출력
		// 기본적으로 return src/main/resources/templates
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("data") String name, Model model) {
		model.addAttribute("data", name);
		return "hello-template";
	}

	// url에서 쿼리스트링으로 값 받음
	// data 라는 이름으로 String 형태로 파라미터값을 받음? 쿼리스트링 값 받음

	@GetMapping("hello-string")
	@ResponseBody // http body부의 데이터를 직접 넣어주겠다
	public String helloString(@RequestParam("data") String name) {
		return "hello" + name;
	}

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
