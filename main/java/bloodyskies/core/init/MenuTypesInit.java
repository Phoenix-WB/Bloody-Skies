package bloodyskies.core.init;

import bloodyskies.BloodySkies;
import bloodyskies.common.container.TestBlockContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuTypesInit {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, BloodySkies.MOD_ID);

    public static final RegistryObject<MenuType<TestBlockContainer>> TEST_BLOCK_MENU_TYPE = MENU_TYPES.register("test_block", () -> IForgeContainerType.create(TestBlockContainer::new));
}
