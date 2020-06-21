package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Mark Angrish
 * @author Lianhua Shen
 */
@NodeEntity
@Getter
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private int released;
//	private String tagline;

	@JsonIgnoreProperties("movie")
	@Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
	private List<Role> roles;

	public Movie() {
	}

	public Movie(String title, int released) {
		this.title = title;
		this.released = released;
//		this.tagline = tagline;
	}


	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(role);
	}
}