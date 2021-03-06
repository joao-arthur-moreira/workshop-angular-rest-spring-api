package com.jajm.patrimonio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jajm.patrimonio.model.Item;
import com.jajm.patrimonio.repository.ItemRepository;

@RestController
@CrossOrigin("${origem-permitida}")
@RequestMapping("/itens")
public class ItemResource {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping
	public List<Item> listar() {
		return itemRepository.findAll();
	}
	
	@PostMapping
	public Item adicionar(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}
}
