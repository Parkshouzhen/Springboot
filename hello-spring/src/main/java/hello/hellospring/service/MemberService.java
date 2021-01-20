package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
		// 외부에서 넣어주도록?
	}

	/*
	 * 회원가입
	 */
	
	public Long join(Member member) {
		// 같은 이름이 있는 중복 회원X
		/*
		 * Optional<Member> result = memberRepository.findByName(member.getName());
		 * result.ifPresent(m -> { //ifPresent: 값이 있으면 (null이 아니면), Optional 안에서 쓸 수 있는
		 * 메소드 throw new IllegalStateException("이미 존재하는 회원입니다."); });
		 */

		validateDuplicateMember(member); // 중복회원 검증
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).
			ifPresent(m -> { // ifPresent: 값이 있으면 (null이 아니면), Optional 안에서 쓸															// 수 있는 메소드
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}
	
	/*
	 * 전체 회원 조회
	 */
	
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
	

}