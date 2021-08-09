package Spring_start.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Spring_start.hello.domain.Member;
import Spring_start.hello.service.MemberService;

@Controller 
public class MemberController {

		private final MemberService memberService;
		
		@Autowired // ������񽺸� ������ �����̳ʿ� �ִ� ������񽺸� ������ �������� DI
		public MemberController(MemberService memberService) {
			this.memberService=memberService;
		}
		
		@GetMapping("/members/new") // ��ȸ��
		public String createForm() {
			return "members/createMemberForm";
		}
		
		@PostMapping("/members/new") // ������ ��Ͻ�
		public String create(MemberForm form)
		{
			Member member = new Member();
			member.setName(form.getName());
			
			memberService.join(member);
			
			return "redirect:/";
			
		}
		
		@GetMapping("/members")
		public String list (Model model)
		{
			List<Member> members= memberService.findMembers();
			model.addAttribute("members",members);
			
			return "members/memberList";
		}

}
