package edu.web.jsp02.dto.user;

import edu.web.jsp02.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserUpdateDto {

	private Integer id;
	private String password;
	private String email;
	
	public User toEntity() {
		return User.builder()
				.id(id).password(password).email(email)
				.build();
				
	}
}
