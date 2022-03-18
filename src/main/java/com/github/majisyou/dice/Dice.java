package com.github.majisyou.dice;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dice extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Diceプラグインジェネレート");


        //ここは定型文
        // config.ymlが存在しないが会いはファイルに出力
        saveDefaultConfig();
        //config.ymlを読み込む
        FileConfiguration config = getConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Diceプラグインが停止した");
        // Plugin shutdown logic
    }
}
