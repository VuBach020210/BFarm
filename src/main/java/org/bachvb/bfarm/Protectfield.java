package org.bachvb.bfarm;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Protectfield extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Plugin ProtectField đã được kích hoạt thành công!");
    }


    @Override
    public void onDisable() {
        // Thực hiện các hoạt động khi plugin bị tắt
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();

        if (block != null && block.getType() == Material.FARMLAND) {
            BlockData blockData = block.getBlockData();
            if (blockData instanceof Levelled) {
                Levelled levelled = (Levelled) blockData;
                levelled.setLevel(levelled.getMaximumLevel());
                block.setBlockData(levelled);
                block.getState().update();
            }
        }
    }
}