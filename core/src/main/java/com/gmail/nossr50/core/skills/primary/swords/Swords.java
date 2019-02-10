package com.gmail.nossr50.core.skills.primary.swords;

import com.gmail.nossr50.core.config.skills.AdvancedConfig;

public class Swords {
    public static int bleedMaxTicks = AdvancedConfig.getInstance().getRuptureMaxTicks();
    public static int bleedBaseTicks = AdvancedConfig.getInstance().getRuptureBaseTicks();

    public static double counterAttackModifier = AdvancedConfig.getInstance().getCounterModifier();

    public static double serratedStrikesModifier = AdvancedConfig.getInstance().getSerratedStrikesModifier();
    public static int serratedStrikesBleedTicks = AdvancedConfig.getInstance().getSerratedStrikesTicks();
}
