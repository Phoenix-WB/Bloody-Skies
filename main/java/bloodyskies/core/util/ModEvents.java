package bloodyskies.core.util;

import bloodyskies.BloodySkies;
import bloodyskies.common.commands.GetCheckDeathEventCommand;
import bloodyskies.common.commands.GetCurrentDayCommand;
import bloodyskies.common.commands.GetDeathDayCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new GetCheckDeathEventCommand(event.getDispatcher());
        new GetCurrentDayCommand(event.getDispatcher());
        new GetDeathDayCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
