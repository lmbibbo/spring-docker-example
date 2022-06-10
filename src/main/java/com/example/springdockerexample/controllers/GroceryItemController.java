package com.example.springdockerexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdockerexample.model.GroceryItem;
import com.example.springdockerexample.services.GroceryItemService;

@RestController
@RequestMapping("api/groceryItems")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping("/")
    public String home(){
     return "Spring REST De Luisma on Java!!!";
    }
 
    @GetMapping("/groceryItems")
    public List<GroceryItem> all(){
        return groceryItemService.list();
    }

    @PostMapping("/groceryItem")
    public GroceryItem create (@RequestBody GroceryItem item) {
        return groceryItemService.create(item);
    }

    @GetMapping("/groceryItem/{itemId}")
    public GroceryItem get (@PathVariable String itemId) {
        return groceryItemService.get(itemId);
    }

    @PutMapping("/groceryItem/{itemId}")
    public GroceryItem update (@RequestBody GroceryItem item) {
        return groceryItemService.update(item);
    }

    @DeleteMapping("/groceryItem/{itemId}")
    public void delete (@PathVariable String itemId) {
        groceryItemService.delete(itemId);
    }

}
