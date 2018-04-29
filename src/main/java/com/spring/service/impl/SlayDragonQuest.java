package com.spring.service.impl;

import com.spring.service.Quest;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest{
    private PrintStream stream;


    public SlayDragonQuest(PrintStream stream){
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("骑士要杀死一条龙");
    }
}
