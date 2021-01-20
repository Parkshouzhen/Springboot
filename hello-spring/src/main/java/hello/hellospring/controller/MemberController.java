package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

@Controller
public class MemberController {
	//스프링 컨테이너에서 스프링빈이 관리된다(?)
	
	private final MemberService memberService;

	@Autowired //의존관계 주입(DI)
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
}
