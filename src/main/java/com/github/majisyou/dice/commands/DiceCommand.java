package com.github.majisyou.dice.commands;

import com.github.majisyou.dice.system.Dicesystem;
import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DiceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        sender.getServer().getLogger().info("diceが実行されました");

        if(args.length < 2){//サブコマンドの個数が0,サブコマンド無し
            sender.sendMessage("§a 引数が足りません");
            sender.sendMessage("§a/dice <サイコロの数> <サイコロの面の数>");
            return true;
        }

        if(!(args[1].chars().allMatch(Character::isDigit)) || !(args[0].chars().allMatch(Character::isDigit))){
            sender.sendMessage("§a 引数が間違っています。");
            sender.sendMessage("第2,3引数には数値が必要です");
            return true;
        }

        int times = Integer.parseInt(args[0]);
        int number = Integer.parseInt(args[1]);


        List<Integer> result = Dicesystem.Dicemain(times, number);
        List<Player> players = new ArrayList<Player>();
        if(args.length > 2){
            for(int i=2; i<args.length-2; i++){
                if(sender.getServer().getPlayer(args[i])==null) players.add(null);
                players.add(sender.getServer().getPlayer(args[i]).isOnline() ? sender.getServer().getPlayer(args[i]) : null);
            }
        }

        for(int i=0; i<times; i++){
            sender.sendMessage((i+1)+"回目の結果: " + result.get(i));
            if(args.length > 2){
                for(int j=0; j<players.size(); j++){
                    if(players.get(j)!=null){
                        players.get(j).sendMessage((i+1)+"回目の結果: " + result.get(i));
                    } else sender.sendMessage(args[j]+"はオンラインじゃないか存在しないよ");
                }
            }
        }

        return true;
    }
}
