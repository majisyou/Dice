package com.github.majisyou.dice.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Dice implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("dice")){
            sender.getServer().getLogger().info("diceが実行されました");
            if(args.length < 2){//サブコマンドの個数が0,サブコマンド無し
                sender.sendMessage(ChatColor.RED+"§a 引数が足りません");
                sender.sendMessage("§a/dice <サイコロの数> <サイコロの面の数>");
            }else{
                if(!(args[2].chars().allMatch(Character::isDigit)) || !(args[1].chars().allMatch(Character::isDigit))){
                    sender.sendMessage(ChatColor.RED+"§a 引数が間違っています。");
                    sender.sendMessage("第2,3引数には数値が必要です");
                    return true;
                }



                sender.sendMessage("§eサブコマンドあり!");
                if(args[0].equalsIgnoreCase("hello")){
                    sender.sendMessage("§Hello world");
                }else{//サブコマンドがhello以外
                    sender.sendMessage("§eその他のサブコマンドです");
                }
            }
            return true;//終わり
        }
        return false;
    }
}
