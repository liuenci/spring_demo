package com.spring.service.impl;

import com.spring.service.Knight;

public class DamselRescuingKnight implements Knight{
    private RescueDamselQuest quest;

    /**
     * 紧耦合
     */
    public DamselRescuingKnight(){
        this.quest = new RescueDamselQuest();
    }
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
