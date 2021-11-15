package bloodyskies.common.commands;

import bloodyskies.common.events.DayEvents;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

public class GetCurrentDayCommand {

    public GetCurrentDayCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("get").then(Commands.literal("currentday").executes((command) -> getCurrentDay(command.getSource()))));
    }

    private int getCurrentDay(CommandSourceStack source) {

        source.sendSuccess(new TextComponent("CurrentDay: " + DayEvents.day), true);

        return 1;

    }
}
