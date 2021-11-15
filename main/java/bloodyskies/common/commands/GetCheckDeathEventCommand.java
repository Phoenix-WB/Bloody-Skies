package bloodyskies.common.commands;

import bloodyskies.common.events.DayEvents;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;


public class GetCheckDeathEventCommand {

    public GetCheckDeathEventCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("get").then(Commands.literal("checkdeathevent").executes((command) -> getCheckDeathEvent(command.getSource()))));
    }

    private int getCheckDeathEvent(CommandSourceStack source) {

        source.sendSuccess(new TextComponent("CheckDeathEvent: " + DayEvents.checkDeathEvent), true);

        return 1;

    }
}
