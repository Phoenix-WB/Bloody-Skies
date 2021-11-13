package bloodyskies.core.init;

import bloodyskies.BloodySkies;
import bloodyskies.common.blockentities.TestBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BloodySkies.MOD_ID);

    public static final RegistryObject<BlockEntityType<TestBlockEntity>> TEST_BLOCK_ENTITY = BLOCK_ENTITIES.register("test_block", () -> BlockEntityType.Builder.of(TestBlockEntity::new, BlockInit.TEST_BLOCK.get()).build(null));
}
