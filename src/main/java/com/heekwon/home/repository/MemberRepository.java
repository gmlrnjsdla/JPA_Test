package com.heekwon.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heekwon.home.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{
	//<엔티티클래스 , 기본키의 타입>
	
	public List<MemberDto> findByName(String memberName);
	

}
