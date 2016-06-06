package com.sxc.easyrules;

import org.easyrules.api.RulesEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: Launcher
 *
 * @author: weimengchao
 * @version: 1.0
 * Create: 2016/6/3
 * Copyright: Copyright (c)2016
 * Company: songxiaocai
 * -
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/6/3       weimengchao    1.0       1.0 Version
 */
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
        RulesEngine rulesEngine = (RulesEngine) context.getBean("rulesEngine");
        rulesEngine.fireRules();
    }
}
