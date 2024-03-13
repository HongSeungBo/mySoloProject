package www.project.domain.football;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.ToString;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FootballStadiumDetailVO {
	private String fcode;
	private String stadiumDetailName;
	private String stadiumSize;
	private String regAt;
}
