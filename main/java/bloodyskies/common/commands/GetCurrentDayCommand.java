package bloodyskies.common.commands;

import bloodyskies.common.events.DayEvents;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;

public class GetCurrentDayCommand {

    public GetCurrentDayCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("get").then(Commands.literal("currentday").executes((command) -> {
            return getCurrentDay(command.getSource()); // THIS
        })));
    }

    private int getCurrentDay(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();

        source.sendSuccess(new TextComponent("CurrentDay: " + DayEvents.day), true);

        return 1;

    }
}
