package com.example.demo.dto;

import com.example.demo.domain.Equipo;

import java.util.List;

public class EquipoListDTO {

	private List<Equipo> equipos;

	public EquipoListDTO() {}

	public List<Equipo> getCars() {
		return equipos;
	}

	public void setCars(List<Equipo> cars) {
		this.equipos = cars;
	}

}
