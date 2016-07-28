package com.sxc.testweb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Description: MysqlConnListener
 *
 * @author: weimengchao
 * @version: 1.0
 * Create: 2016/5/31
 * Copyright: Copyright (c)2016
 * Company: songxiaocai
 * -
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/5/31       weimengchao    1.0       1.0 Version
 */
@WebListener
public class MysqlConnListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            System.out.println("获取数据库连接");

            ServletContext context = servletContextEvent.getServletContext();
            String driver = context.getInitParameter("driver");
            String url = context.getInitParameter("url");
            String user = context.getInitParameter("user");
            String pwd = context.getInitParameter("pwd");

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pwd);

            context.setAttribute("conn", conn);
        } catch (Exception e) {
            System.out.println("获取数据库连接异常:" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("关闭数据库连接");

        ServletContext context = servletContextEvent.getServletContext();
        Connection conn = (Connection) context.getAttribute("conn");
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
