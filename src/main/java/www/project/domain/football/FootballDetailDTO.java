package www.project.domain.football;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FootballDetailDTO {
	private FootballStadiumDetailVO fsdvo;
	private FootballStadiumDetailFileVO fsdfvo;
}
