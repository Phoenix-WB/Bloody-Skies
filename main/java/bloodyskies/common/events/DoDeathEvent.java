package bloodyskies.common.events;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;

import java.util.UUID;


public class DoDeathEvent {

    private static final Minecraft minecraft = Minecraft.getInstance();

    public void twoToGo() {
        minecraft.player.sendMessage(new TextComponent("You have two days left..."), new UUID(100, 0));
    }

    public void oneToGo() {
        minecraft.player.sendMessage(new TextComponent("You have one day left..."), new UUID(100, 0));

    }

    public void firstDay() {
        minecraft.player.sendMessage(new TextComponent("Today is your last..."), new UUID(100, 0));

    }

    public void secondDay() {
        minecraft.player.sendMessage(new TextComponent("Wow, but seriously... You can't escape..."), new UUID(100, 0));

    }

    public void thirdDay() {
        minecraft.player.sendMessage(new TextComponent("Goodbye..."), new UUID(100, 0));

        minecraft.player.kill();

    }
}
