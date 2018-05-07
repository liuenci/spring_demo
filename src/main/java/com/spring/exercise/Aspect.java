package com.spring.exercise;


import org.apache.log4j.Logger;

public class Aspect {

    private static Logger logger = Logger.getLogger(Aspect.class);

    public void before(){
        logger.info("小明已经上大三了，还是没有女朋友。在寝室的哥们的怂恿下，他决定去追一个心仪已久的女生。  ");
    }

    public void after(){
        logger.info("眼看那个女生越走越远，他只好从地上捡了一样东西，追上去说：“小姐，这块砖头是不是你掉的啊？”");
    }
}
