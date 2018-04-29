package com.spring.Config;

import com.spring.service.Knight;
import com.spring.service.Quest;
import com.spring.service.impl.BraveKnight;
import com.spring.service.impl.SlayDragonQuest;
import org.springframework.context.annotation.Bean;

public class KnightConfig {
    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }
    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);
    }
}
