package bloodyskies.common.commands;

import bloodyskies.common.events.DayEvents;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

public class GetCheckDeathEventCommand {

    public GetCheckDeathEventCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("get").then(Commands.literal("checkdeathevent").executes((command) -> {
            return getCheckDeathEvent(command.getSource()); // THIS
        })));
    }

    private int getCheckDeathEvent(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();

        source.sendSuccess(new TextComponent("CheckDeathEvent: " + DayEvents.checkDeathEvent), true);

        return 1;

    }
}
