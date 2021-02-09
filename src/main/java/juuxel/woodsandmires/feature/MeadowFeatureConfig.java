package juuxel.woodsandmires.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public final class MeadowFeatureConfig implements FeatureConfig {
    public static final Codec<MeadowFeatureConfig> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            BlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter(MeadowFeatureConfig::getStateProvider),
            Codec.FLOAT.fieldOf("chance").forGetter(MeadowFeatureConfig::getChance)
        ).apply(instance, MeadowFeatureConfig::new)
    );

    final BlockStateProvider stateProvider;
    final float chance;

    public MeadowFeatureConfig(BlockStateProvider stateProvider, float chance) {
        this.stateProvider = stateProvider;
        this.chance = chance;
    }

    public BlockStateProvider getStateProvider() {
        return stateProvider;
    }

    public float getChance() {
        return chance;
    }
}
