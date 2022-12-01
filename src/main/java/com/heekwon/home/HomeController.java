package com.heekwon.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heekwon.home.dto.MemberDto;
import com.heekwon.home.repository.MemberRepository;

@Controller
public class HomeController {

	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value="join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="joinOk")
	public String joinOk(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); 
		int grade = Integer.parseInt(request.getParameter("grade"));
		String etc = request.getParameter("etc");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setName(name);
		memberDto.setAge(age);
		memberDto.setGrade(grade);
		memberDto.setEtc(etc);
		
		MemberDto mdto = memberRepository.save(memberDto);
		
		System.out.println(mdto.toString());
		
		return "joinOk";
	}
	
	@RequestMapping(value="search")
	public String search() {
		
		List<MemberDto> memberDtos =  memberRepository.findByName("홍길동");
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto);
		}
		
		return "searchResult";
	}
	
}
