package model.DTO;

import java.sql.Timestamp;
import java.util.Date;

import oracle.sql.TIMESTAMP;

public class MemberDTO {
           String memberId;
           String memberPassword;
           String memberTel;           
           String memberGender;
           
		
        
       
           
           
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getMemberPassword() {
			return memberPassword;
		}
		public void setMemberPassword(String memberPassword) {
			this.memberPassword = memberPassword;
		}
		public String getMemberTel() {
			return memberTel;
		}
		public void setMemberTel(String memberTel) {
			this.memberTel = memberTel;
		}
		
		public String getMemberGender() {
			return memberGender;
		}
		public void setMemberGender(String memberGender) {
			this.memberGender = memberGender;
		}
		
           
           
           
}
