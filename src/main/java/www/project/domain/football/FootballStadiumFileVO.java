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
public class FootballStadiumFileVO {
	private String uuid;
	private String fileName;
	private String saveDir;
	private String fcode;	
}
