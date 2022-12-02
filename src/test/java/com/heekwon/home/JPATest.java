package com.heekwon.home;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.heekwon.home.dto.MemberDto;
import com.heekwon.home.repository.MemberRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application_test.properties")
public class JPATest {
	
	@Autowired
	MemberRepository memberRepository;
	
//	@Test
//	@DisplayName("이름 검색 테스트")
//	public void searchName() {
//		
//		List<MemberDto> dtos = memberRepository.findByNameContaining("홍");
//		
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto.toString());
//		}
//		
//	}
//	
//	@Test
//	@DisplayName("회원 삭제 테스트")
//	public void deleteMember() {
//		
//		Long hak = (long) 3;
//		
//		Optional<MemberDto> dto = memberRepository.findById(hak);
//		
////		assertTrue(dto.isPresent());
//		
////		MemberDto memberdto = dto.get();
////		memberRepository.delete(memberdto);
//		memberRepository.deleteById(hak);
//		
//		List<MemberDto> dtos = memberRepository.findAll();
//		
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto.toString());
//		}
//		
//	}
	
//	@Test
//	@DisplayName("이름 검색 테스트")
//	public void searchMember() {
//		
//		List<MemberDto> dtos = memberRepository.findByNameLike("홍%");
//		
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto.toString());
//		}
//		
//	}
	
//	@Test
//	@DisplayName("특정 회원 삭제 테스트")
//	public void deleteMember() {
//		
//		memberRepository.deleteById(5L);
//		
//		List<MemberDto> dtos = memberRepository.findAll();
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto.toString());
//		}
//		
//	}
	
	@Test
	@DisplayName("회원 수정 테스트")
	public void modifyMember() {
		
		Optional<MemberDto> dto = memberRepository.findById(7L);
		
		assertTrue(dto.isPresent());
		
		MemberDto memberdto = dto.get();
		
		memberdto.setName("이순신");
		
		memberRepository.save(memberdto);
		
		
		List<MemberDto> dtos = memberRepository.findAll();
		
		for(MemberDto memberDto : dtos) {
			System.out.println(memberDto.toString());
		}
		
	}
	
}
