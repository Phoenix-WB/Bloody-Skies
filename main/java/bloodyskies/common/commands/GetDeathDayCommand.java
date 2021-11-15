package bloodyskies.common.commands;

import bloodyskies.common.events.DayEvents;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

public class GetDeathDayCommand {

    public GetDeathDayCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("get").then(Commands.literal("deathday").executes((command) -> getDeathDay(command.getSource()))));
    }

    private int getDeathDay(CommandSourceStack source) {

        source.sendSuccess(new TextComponent("DeathDay: " + DayEvents.dayToDie), true);

        return 1;

    }
}
