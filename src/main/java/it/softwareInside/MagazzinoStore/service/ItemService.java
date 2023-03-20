package it.softwareInside.MagazzinoStore.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public boolean addItemToDatabase(Item item) {
		if(item == null)
			return false;
		
		try {
			itemRepository.save(item);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public ArrayList<Item> readItems() {
		ArrayList<Item> allItems = (ArrayList<Item>) itemRepository.findAll();
		return allItems;
	}
	
	public Item deleteItemById(Integer id) {
		Item item = itemRepository.findById(id).get();
		itemRepository.deleteById(id);
		return item;
	}
	
	public boolean updateItemById(Item item) {
		itemRepository.findById(item.getId()).get();
		itemRepository.save(item);
		return true;
	}
	
	public double costoComplessivo() {
		double costoTotale = 0.0;
		ArrayList<Item> allItems = (ArrayList<Item>) itemRepository.findAll();
		for(Item item : allItems) {
			costoTotale += item.getCosto();
		}
		return costoTotale;
	}
	
}
