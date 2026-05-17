package net.videobot.additional_biomes.worldgen.levelgen.biome;

import net.videobot.additional_biomes.worldgen.levelgen.biome.selector.BiomeSelector;

import javax.swing.plaf.synth.Region;

public class AdditionalTerraBlenderRegions extends Region {
    public static final AdditionalTerraBlenderRegions REGION1 = new AdditionalTerraBlenderRegions(
            BiomeSelector.FOREST_BIOMES
    )

    /**
     * Creates a Region with the specified name. This should only be
     * used if you are creating your own <code>JComponent</code> subclass
     * with a custom <code>ComponentUI</code> class.
     *
     * @param name      Name of the region
     * @param ui        String that will be returned from
     *                  <code>component.getUIClassID</code>. This will be null
     *                  if this is a subregion.
     * @param subregion Whether or not this is a subregion.
     */
    protected AdditionalTerraBlenderRegions(String name, String ui, boolean subregion) {
        super(name, ui, subregion);
    }

    public static void registerTerraBlenderRegions() {
        REGION1.register(REGION1);
    }
}
