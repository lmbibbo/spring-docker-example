package com.example.springdockerexample.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdockerexample.model.GroceryItem;
import com.example.springdockerexample.repository.ItemRepository;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public GroceryItem create(GroceryItem item) {
        return itemRepository.insert(item);
    }

    @Override
    public List<GroceryItem> list() {
        return itemRepository.findAll();
    }

    @Override
    public GroceryItem update(GroceryItem item) {
        return itemRepository.save(item);
    }

    @Override
    public Map<String, String> delete(String id) {

        long beforeDelete = itemRepository.count();

        itemRepository.deleteById(id);

        long afterDelete = itemRepository.count();

        String messageValue = beforeDelete == afterDelete ? "Something went wrong!" : "Record deleted";

        Map<String, String> deleteMap = new HashMap<>();
        deleteMap.put("message", messageValue);

        return deleteMap;
    }

    @Override
    public GroceryItem get(String itemId) {
        return itemRepository.findItemByName(itemId);
    }
    
}
