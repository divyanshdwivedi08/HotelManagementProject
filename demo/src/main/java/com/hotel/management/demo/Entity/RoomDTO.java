package com.hotel.management.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
	private String roomNumber;
	private String roomType;
	private Double pricePerNight;
	private String roomStatus;
	
}