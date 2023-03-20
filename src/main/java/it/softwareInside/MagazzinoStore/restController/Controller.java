package it.softwareInside.MagazzinoStore.restController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.service.ItemService;

@RestController
public class Controller {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/add")
	public boolean addItem(@RequestBody Item item) {
		return itemService.addItemToDatabase(item);
	}
	
//	@PostMapping("/delete")
//	public Item deleteItem(@RequestBody int id) {
//		return itemService.deleteItemById(id);
//	}
	
	@DeleteMapping("/delete")
	public Item deleteItem(Integer id) {
		return itemService.deleteItemById(id);
	}
	
	@PostMapping("/update")
	public boolean updateItem(@RequestBody Item item) {
		return itemService.updateItemById(item);
	}
	
	@PostMapping("/costo-totale")
	public double totalItems() {
		return itemService.costoComplessivo();
	}
	
	@PostMapping("/read")
	public ArrayList<Item> readAllItems() {
		return itemService.readItems();
	}
}
