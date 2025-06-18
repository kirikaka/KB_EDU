package org.example.kbspring.dto.forecast;

import lombok.Data;

@Data
public class Wind{
	private int deg;
	private Object speed;
	private Object gust;
}