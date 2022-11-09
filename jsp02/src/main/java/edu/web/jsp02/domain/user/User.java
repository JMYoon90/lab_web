package edu.web.jsp02.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer points;
	
}
