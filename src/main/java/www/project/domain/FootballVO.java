package www.project.domain;

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
public class FootballVO {
	private String fCode; //구장코드
	private String city; //도시
	private String districe; //세부지역
	private String availableOpen; //시작시간
	private String availableClose; //종료시간
	private int totalStadiumNum; //총구장수
	private int available; //이용가능구장수
}
