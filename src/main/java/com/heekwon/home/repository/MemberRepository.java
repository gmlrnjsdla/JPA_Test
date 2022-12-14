package com.heekwon.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heekwon.home.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{
	//<엔티티클래스 , 기본키의 타입>
	
	public List<MemberDto> findByName(String memberName);
	public List<MemberDto> findByHakbun(Long hakbun);
	public List<MemberDto> findByNameOrderByHakbunDesc(String memberName);
	public List<MemberDto> findAllByOrderByHakbunDesc();
	public List<MemberDto> findByNameOrGrade(String mamberName,int grade);
	public List<MemberDto> findByAgeLessThan(int age);	//미만
	public List<MemberDto> findByAgeLessThanEqual(int age);	//이하
	public List<MemberDto> findByAgeGreaterThan(int age);	//초과
	public List<MemberDto> findByAgeGreaterThanEqual(int age);	//이상
	public List<MemberDto> findByAgeBetween(int startAge, int EndAge);	//사잇값
	public List<MemberDto> findByNameContaining(String nameKey);	//특정문자포함
	public List<MemberDto> findByNameLike(String nameKey);	//특정문자포함
	
	
	//데이터 삭제
	public void deleteAllByName(String name); //이름으로 조회하여 삭제
	
}
