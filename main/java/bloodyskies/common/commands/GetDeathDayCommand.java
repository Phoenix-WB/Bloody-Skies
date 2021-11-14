package bloodyskies.common.commands;

import bloodyskies.common.events.DayEvents;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;

public class GetDeathDayCommand {

    public GetDeathDayCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("get").then(Commands.literal("deathday").executes((command) -> {
            return getDeathDay(command.getSource()); // THIS
        })));
    }

    private int getDeathDay(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();

        source.sendSuccess(new TextComponent("DeathDay: " + DayEvents.dayToDie), true);

        return 1;

    }
}
