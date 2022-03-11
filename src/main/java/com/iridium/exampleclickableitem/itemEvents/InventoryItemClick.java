package com.iridium.exampleclickableitem.itemEvents;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.function.Consumer;


public class InventoryItemClick implements Listener {

    public static InventoryItemClick self = new InventoryItemClick();
    private final HashMap<ItemStack, Consumer<InventoryClickEvent>> items = new HashMap<>();

    public void setClickEvent(ItemStack item, Consumer<InventoryClickEvent> event){
        items.put(item, event);
    }
    public void removeClickEvent(ItemStack item){
        items.remove(item);
    }

    public HashMap<ItemStack, Consumer<InventoryClickEvent>> get(){
        return items;
    }
}
