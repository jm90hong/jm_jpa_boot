package com.my.jm_jpa_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.jm_jpa_boot.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
