package com.uchuika.anniaddon;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageModifyEvent;
import net.minecraft.client.Minecraft;

public class AnniMessageReciveEvent {
    @Subscribe
    public void onChat(MessageModifyEvent event) {
        String chat = event.getComponent().getString();

        onReceiveChat(chat);
    }

    public static void onReceiveChat(String chat) {
        String[] split = chat.split((" "));

        //System.out.println("chat:" + chat + "type:" + type);
        if(split.length>=3&&chat.contains("killed") || chat.contains("shot")) {
            String killer=split[0].substring(0, split[0].length()-5);

            //"killed"と"shot"の場合のkillカウント
            if(killer.contains(Minecraft.getInstance().player.getName().getString())) {
                if(split.length>=4) {
                    String addinfo = split[3];
                    if(addinfo.contains("attacking")){
                        AnniPlayerData.meleekillCount++;
                        AnniPlayerData.activekillCount++;
                        AnniStatusAddon.get().getApi().displayMessageInChat("kill");
                    }else if(addinfo.contains("defending")) {
                        AnniPlayerData.meleekillCount++;
                        AnniPlayerData.activekillCount++;
                        AnniStatusAddon.get().getApi().displayMessageInChat("kill");
                    }else if(addinfo.contains("in")) {
                        AnniPlayerData.meleekillCount++;
                        AnniPlayerData.activekillCount++;
                        AnniStatusAddon.get().getApi().displayMessageInChat("kill");
                    }
                }else {
                    //Minecraft.getInstance().player.sendMessage(new StringTextComponent("kill"), Util.DUMMY_UUID);
                    AnniStatusAddon.get().getApi().displayMessageInChat("kill");

                    AnniPlayerData.meleekillCount++;
                    AnniPlayerData.activekillCount++;
                }
            }
        }
        if (chat.contains("Killing a recently re-spawned player doesn't count towards your Annihilation stats, rank points & Shotbow XP.") || chat.contains("Killing a recently re-spawned player doesn't count towards your Berserker health, Annihilation stats, rank points & Shotbow XP.")){
            AnniPlayerData.activekillCount--;
        }
    }
}
