package com.github.kumo0621.jumpboost;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class Jumpboost extends JavaPlugin implements org.bukkit.event.Listener {

    Collection<? extends Player> player = Bukkit.getOnlinePlayers();
    boolean start = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        new BukkitRunnable() {

            @Override

            public void run() {
                //何かやりたいときはここに書き込む

                if (start) {
                    Bukkit.broadcastMessage("ジャンプ力が変わった！！");
                    for (Player set : player) {
                        int count = random.random();
                        set.removePotionEffect(PotionEffectType.JUMP);
                        set.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, count));
                    }
                }
            }
        }.runTaskTimer(this, 0L, 600L);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equals("jump")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                    sender.sendMessage("引数を指定してください。");
                } else {
                    switch (args[0]) {
                        case "start":
                            start = true;
                            Bukkit.broadcastMessage("ジャンプ力が変わるようになった！！");
                            for (Player set : player) {
                                int count = random.random();
                                set.removePotionEffect(PotionEffectType.JUMP);
                                set.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, count));
                            }
                                break;
                        case "end":
                            start = false;
                            break;
                    }
                }
            }

        }
        return super.onCommand(sender, command, label, args);
    }
}
