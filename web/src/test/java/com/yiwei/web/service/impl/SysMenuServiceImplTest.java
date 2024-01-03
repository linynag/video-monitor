package com.yiwei.web.service.impl;

import com.yiwei.web.mapper.SysMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SysMenuServiceImplTest {

    @Autowired
    private SysMenuMapper menuMapper;

    @Test
    public void testSelectPermsByUserId() {
        // L表示Long类型
        List<String> list = menuMapper.selectPermsByUserId(2L);
        System.out.println(list);
    }
}