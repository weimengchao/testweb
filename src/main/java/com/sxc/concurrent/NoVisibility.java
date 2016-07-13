package com.sxc.concurrent;

/**
 * Description: NoVisibility
 *
 * @author: weimengchao
 * @version: 1.0
 * Create: 2016/6/30
 * Copyright: Copyright (c)2016
 * Company: songxiaocai
 * -
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/6/30       weimengchao    1.0       1.0 Version
 */
public class NoVisibility {
    private static boolean ready;
    private static int num;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        num = 42;
        ready = true;

    }
}
