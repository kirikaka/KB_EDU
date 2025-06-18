package org.example.kbspring.dto.forecast;

import java.util.List;
import lombok.Data;

@Data
public class ForecastDto {
	private City city;
	private int cnt;
	private String cod;
	private int message;
	private List<ListItem> list;
}