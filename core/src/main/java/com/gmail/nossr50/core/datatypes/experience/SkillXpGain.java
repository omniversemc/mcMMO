package com.gmail.nossr50.core.datatypes.experience;

import com.gmail.nossr50.config.experience.ExperienceConfig;
import com.gmail.nossr50.core.skills.PrimarySkillType;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class SkillXpGain implements Delayed {
    private final long expiryTime;
    private final float xp;
    private final PrimarySkillType type;

    public SkillXpGain(PrimarySkillType type, float xp) {
        this.expiryTime = System.currentTimeMillis() + getDuration();
        this.xp = xp;
        this.type = type;
    }

    private static long getDuration() {
        return TimeUnit.MINUTES.toMillis(ExperienceConfig.getInstance().getDiminishedReturnsTimeInterval());
    }

    public PrimarySkillType getSkill() {
        return type;
    }

    public float getXp() {
        return xp;
    }

    public int compareTo(SkillXpGain other) {
        if (this.expiryTime < other.expiryTime) {
            return -1;
        } else if (this.expiryTime > other.expiryTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public int compareTo(Delayed other) {
        if (other instanceof SkillXpGain) {
            // Use more efficient method if possible (private fields)
            return this.compareTo((SkillXpGain) other);
        }
        return (int) (getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public long getDelay(TimeUnit arg0) {
        return arg0.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}
