package com.example.springdockerexample.repository;

public interface CustomItemRepository {
    void updateItemQuantity(String itemName, float newQuantity);
}
