package io.davidarchanjo.code;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
	private long id;
	private String firstName;
	private String lastName;
}
