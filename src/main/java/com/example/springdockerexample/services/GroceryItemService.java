package com.example.springdockerexample.services;

import org.springframework.stereotype.Service;
import com.example.springdockerexample.model.GroceryItem;

import java.util.List;
import java.util.Map;

@Service
public interface GroceryItemService {

    GroceryItem create(GroceryItem item);

    List<GroceryItem> list();

    GroceryItem get(String itemId);

    GroceryItem update(GroceryItem item);

    Map<String, String> delete(String id);

}
