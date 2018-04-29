package com.spring.service.impl;

import com.spring.service.Knight;
import com.spring.service.Quest;

public class BraveKnight implements Knight{
    private Quest quest;

    /**
     * 构造器注入
     * 松耦合
     * @param quest
     */
    public BraveKnight(Quest quest){
        this.quest = quest;
    }
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
