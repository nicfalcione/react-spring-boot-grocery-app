package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GroceryItems")
public class GroceryListItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "checked")
    private boolean checked;

    @Column(name = "item")
    private String item;

    public GroceryListItem() {

    }

    public GroceryListItem(long id, boolean checked, String item) {
        this.id = id;
        this.checked = checked;
        this.item = item;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public GroceryListItem id(long id) {
        setId(id);
        return this;
    }

    public GroceryListItem checked(boolean checked) {
        setChecked(checked);
        return this;
    }

    public GroceryListItem item(String item) {
        setItem(item);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", checked='" + isChecked() + "'" +
            ", item='" + getItem() + "'" +
            "}";
    }
}