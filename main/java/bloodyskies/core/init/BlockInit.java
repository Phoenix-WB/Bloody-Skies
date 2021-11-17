package bloodyskies.core.init;

import bloodyskies.BloodySkies;
import bloodyskies.common.block.TestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BloodySkies.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new TestBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.CLAY).noOcclusion()));
}
