package com.my.jm_jpa_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.jm_jpa_boot.dto.ItemDTO;
import com.my.jm_jpa_boot.entity.Item;
import com.my.jm_jpa_boot.repository.ItemRepository;

@Service
public class ItemService {

//	private final UserRepository userRepository;
//
//	public UserService(UserRepository userRepository) {
//	    this.userRepository = userRepository;
//	}
	
	
	
	@Autowired
	ItemRepository itemRepository;
	
	

	// 모든 Item을 조회하면서 User의 닉네임도 포함하여 반환
    public List<ItemDTO> getAllItems() {
    	//loop를 활용 하여 닉네임 설정
        return itemRepository.findAll().stream()
                .map(item -> new ItemDTO(
                        item.getItemIdx(),
                        item.getName(),
                        item.getCreatedDate(),
                        item.getUser().getNick()  // User의 닉네임 가져오기
                ))
                .collect(Collectors.toList());
    }
	
	// Create or Update User
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
	
    
}
