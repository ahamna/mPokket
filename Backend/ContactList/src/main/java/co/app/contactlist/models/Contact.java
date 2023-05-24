package co.app.contactlist.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact extends Base {
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String phone;
}
