package com.iridium.exampleclickableitem.listener;

import com.iridium.exampleclickableitem.itemEvents.InventoryItemClick;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Handler implements Listener {
    private final InventoryItemClick invClick = InventoryItemClick.self;
    @EventHandler
    public void inventoryClick(InventoryClickEvent event){
        invClick.get().forEach((itemStack, runnable) -> {
            if (itemStack.equals(event.getCurrentItem())){
                runnable.accept(event);
            }
        });
    }
//    Example usage
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        ItemStack clickableItem = new ItemStack(Material.COMPASS);
        ItemMeta meta = clickableItem.getItemMeta();
        meta.displayName(Component.text("This is clickable"));
        clickableItem.setItemMeta(meta);
        invClick.setClickEvent(clickableItem, e ->
                e.getWhoClicked().sendMessage(Component.text("WOW! It works!")));

        ItemStack notClickableItem = new ItemStack(Material.COMPASS);
        meta.displayName(Component.text("This is NOT clickable"));
        notClickableItem.setItemMeta(meta);

        event.getPlayer().getInventory().setItem(0, clickableItem);
        event.getPlayer().getInventory().setItem(1, notClickableItem);
    }
}
