package com.spring.knights;

import com.spring.service.Quest;
import com.spring.service.impl.BraveKnight;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest(){
        // 创建 mock Quest
        Quest mockQuest = mock(Quest.class);
        // 注入 mock Quest
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        // Mockito 框架验证 Quest 的 mock 实现的 embark() 方法仅仅调用了一次
        verify(mockQuest,times(1)).embark();
    }
}
