package it.softwareInside.MagazzinoStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	private String tipologia;
	private double costo;
	private String marca;
	
	//COSTRUTTORE SENZA ID
	public Item(String tipologia, double costo, String marca) {
		setTipologia(tipologia);
		setCosto(costo);
		setMarca(marca);
	}
}
