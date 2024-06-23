package com.jeancalistro.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

public class CommandFix implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory inventoryPlayer = player.getInventory();

            ItemStack itemInHand = inventoryPlayer.getItemInMainHand();
            Damageable item = (Damageable) itemInHand.getItemMeta();

            if(item != null) {
                item.setDamage(0);
                itemInHand.setItemMeta(item.clone());

                player.sendMessage("Item Consertado");
            }
            else {
                player.sendMessage("Coloque o item à ser consertado na mão");
            }
        }

        return true;
    }
}
