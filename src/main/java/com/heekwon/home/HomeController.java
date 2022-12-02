package com.heekwon.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="search")
	public String search() {
		return "search";
	}
	
	@RequestMapping(value="joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
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
		
		model.addAttribute("mDto", mdto);
		
		System.out.println(mdto.toString());
		
		return "joinOk";
	}
	
	@RequestMapping(value="searchOk")
	public String search(HttpServletRequest request,Model model) {
		
		String name = request.getParameter("name");
//		List<MemberDto> memberDtos =  memberRepository.findByName(name);
		List<MemberDto> memberDtos = memberRepository.findByNameOrderByHakbunDesc(name);
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto);
		}
		
		model.addAttribute("searchDtos", memberDtos);
		
		return "searchResult";
	}
	
	@RequestMapping(value="allmember")
	public String allmember(HttpServletRequest request,Model model) {
		
		List<MemberDto> memberDtos = memberRepository.findAllByOrderByHakbunDesc();
//		List<MemberDto> memberDtos2 = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "hakbun"));
//		List<MemberDto> memberDtos = memberRepository.findByNameOrGrade("홍길동", 1);
//		List<MemberDto> memberDtos = memberRepository.findByAgeLessThan(60);
//		List<MemberDto> memberDtos = memberRepository.findByNameContaining("홍");
		
		model.addAttribute("allmember", memberDtos);
		
		return "allmember";
	}
	
	
	
}
