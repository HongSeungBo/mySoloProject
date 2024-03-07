package www.project.domain.football;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FootballDTO {
	private FootballVO fbvo;
	private FootballStadiumFileVO fbsfvo;
}
