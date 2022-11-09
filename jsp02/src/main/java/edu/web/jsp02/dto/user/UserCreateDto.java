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
public class UserCreateDto {

	private String username;
	private String password;
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username).password(password).email(email)
				.build();
	}
}
