package www.project.domain.football;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StadiumDetailVO {
	private String fcode;
	private String stadiumDetailName;
	private String size;
	private String regAt;
}
