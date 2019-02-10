package com.gmail.nossr50.events.skills;

import com.gmail.nossr50.core.data.UserManager;
import com.gmail.nossr50.core.skills.PrimarySkillType;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Generic event for mcMMO skill handling.
 */
public abstract class McMMOPlayerSkillEvent extends PlayerEvent {
    /**
     * Rest of file is required boilerplate for custom events
     **/
    private static final HandlerList handlers = new HandlerList();
    protected PrimarySkillType skill;
    protected int skillLevel;

    protected McMMOPlayerSkillEvent(Player player, PrimarySkillType skill) {
        super(player);
        this.skill = skill;
        this.skillLevel = UserManager.getPlayer(player).getSkillLevel(skill);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * @return The skill involved in this event
     */
    public PrimarySkillType getSkill() {
        return skill;
    }

    /**
     * @return The level of the skill involved in this event
     */
    public int getSkillLevel() {
        return skillLevel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
