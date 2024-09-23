package com.my.jm_jpa_boot.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.jm_jpa_boot.dto.ItemDTO;
import com.my.jm_jpa_boot.entity.Item;
import com.my.jm_jpa_boot.entity.User;
import com.my.jm_jpa_boot.repository.UserRepository;
import com.my.jm_jpa_boot.service.ItemService;
import com.my.jm_jpa_boot.service.UserService;

@RestController
@RequestMapping(value="api/item")
public class ItemController {
	
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	

	//연관 관계로 item-user(join) 조회 하기
	//모든 Item 조회
    @GetMapping("all")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    //부분 조회
    @GetMapping("some")
    public ResponseEntity<List<ItemDTO>> getSomeItems(
    			@RequestParam(value="s") int start,
    			@RequestParam(value="c") int count
    		) {
    	
        List<ItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
	
	
	@GetMapping("save")
	public ResponseEntity<Item> save(
				@RequestParam(value="user_idx") int user_idx,
				@RequestParam(value="name") String name
			) {
		
		Optional<User> user = userRepository.findById(user_idx);
		
		
		Item item = Item.builder()
			.user(user.get())
			.name(name)
			.createdDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
			.build();
                
		Item savedItem = itemService.saveItem(item);
		
		return ResponseEntity.ok(savedItem);
	}
	
}
