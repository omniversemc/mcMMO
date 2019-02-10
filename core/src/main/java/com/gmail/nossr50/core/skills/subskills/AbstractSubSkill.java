package com.gmail.nossr50.core.skills.subskills;

import com.gmail.nossr50.core.config.skills.CoreSkillsConfig;
import com.gmail.nossr50.core.skills.SubSkillType;
import com.gmail.nossr50.core.skills.subskills.interfaces.Interaction;
import com.gmail.nossr50.core.skills.subskills.interfaces.Rank;
import com.gmail.nossr50.core.skills.subskills.interfaces.SubSkill;
import com.gmail.nossr50.core.skills.subskills.interfaces.SubSkillProperties;
import com.gmail.nossr50.locale.LocaleLoader;
import org.bukkit.entity.Player;

public abstract class AbstractSubSkill implements SubSkill, Interaction, Rank, SubSkillProperties {
    /*
     * The name of the subskill is important is used to pull Locale strings and config settings
     */
    protected String configKeySubSkill;
    protected String configKeyPrimary;
    protected SubSkillType subSkillType;

    public AbstractSubSkill(String configKeySubSkill, String configKeyPrimary, SubSkillType subSkillType) {
        this.configKeySubSkill = configKeySubSkill;
        this.configKeyPrimary = configKeyPrimary;
        this.subSkillType = subSkillType;
    }

    /**
     * Returns the simple description of this subskill from the locale
     *
     * @return the simple description of this subskill from the locale
     */
    @Override
    public String getDescription() {
        return LocaleLoader.getString(getPrimaryKeyName() + ".SubSkill." + getConfigKeyName() + ".Description");
    }

    /**
     * Whether or not this subskill is enabled
     *
     * @return true if enabled
     */
    @Override
    @Deprecated
    public boolean isEnabled() {
        //TODO: This might be troublesome...
        return CoreSkillsConfig.getInstance().isSkillEnabled(this);
    }

    /**
     * Prints detailed info about this subskill to the player
     *
     * @param player the target player
     */
    @Override
    public void printInfo(Player player) {
        /* DEFAULT SETTINGS PRINT THE BARE MINIMUM */

        //TextComponentFactory.sendPlayerUrlHeader(player);
        player.sendMessage(LocaleLoader.getString("Commands.MmoInfo.Header"));
        player.sendMessage(LocaleLoader.getString("Commands.MmoInfo.SubSkillHeader", getConfigKeyName()));
        player.sendMessage(LocaleLoader.getString("Commands.MmoInfo.DetailsHeader"));
    }

    public SubSkillType getSubSkillType() {
        return subSkillType;
    }
}
