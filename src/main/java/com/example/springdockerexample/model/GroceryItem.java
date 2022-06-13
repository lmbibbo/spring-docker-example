package com.example.springdockerexample.model;

import org.springframework.data.annotation.Id;

public class GroceryItem {
		@Id
		private String id;

		private String name;
		private int quantity;
		private String category;
		
		public GroceryItem(String id, String name, int quantity, String category) {
			super();
			this.id = id;
			this.name = name;
			this.quantity = quantity;
			this.category = category;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getItemQuantity() {
			return quantity;
		}

		public void setItemQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
}
