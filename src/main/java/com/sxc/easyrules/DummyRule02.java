package com.sxc.easyrules;


import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

/**
 * Description: DummyRule
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
@Rule(name = "dummyRule02")
public class DummyRule02 {

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then(){
        System.out.println("02 Hey, I'm managed by Spring");
    }

}
