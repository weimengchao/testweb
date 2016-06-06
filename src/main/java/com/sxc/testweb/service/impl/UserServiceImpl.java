package com.sxc.testweb.service.impl;

import com.sxc.testweb.dao.UserMapper;
import com.sxc.testweb.domain.User;
import com.sxc.testweb.domain.UserExample;
import com.sxc.testweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: UserServiceImpl
 *
 * @author: weimengchao
 * @version: 1.0
 * Create: 2016/6/1
 * Copyright: Copyright (c)2016
 * Company: songxiaocai
 * -
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/6/1       weimengchao    1.0       1.0 Version
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public boolean login(String username, String password) {
        boolean result = true;


            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();

            if (username != null && !"".equals(username)) {
                criteria.andUsernameEqualTo(username);
            }

            if (password != null && !"".equals(password)) {
                criteria.andPasswordEqualTo(password);
            }

            List<User> rs = userMapper.selectByExample(example);

            if (rs != null && rs.size() > 0) {
                result = true;
            } else {
                result = false;
            }


        return result;
    }
}
