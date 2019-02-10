package com.gmail.nossr50.core.skills.interfaces;

import com.gmail.nossr50.core.skills.PrimarySkillType;

public interface Skill {
    /**
     * The primary skill
     *
     * @return this primary skill
     */
    PrimarySkillType getPrimarySkill();

    /**
     * Returns the key name used for this skill in conjunction with config files
     *
     * @return config file key name
     */
    String getPrimaryKeyName();
}
