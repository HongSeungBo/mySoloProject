package www.project.domain.football;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class FootballStadiumDetailFileVO {
	private String fcode;
	private String stadiumDetailName;
	private String uuid;
	private String saveDir;
	private String fileName;
	private String regAt;
}
