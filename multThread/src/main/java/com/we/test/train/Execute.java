package com.we.test.train;

/**
 * @Description: 火车票测试->三个售票窗口同时出售20张票
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/10/29 6:46 下午
 */
public class Execute extends Thread {

    //创建一个静态的钥匙
    private static Object key = "key";
    //票数量
    private static int ticketNum = 20;

    public Execute(String name) {
        super(name);
    }

    /**
     * 执行卖票的业务
     */
    @Override
    public void run() {
        //如果票的总数大于0的话代表票库还有票
        while (ticketNum > 0) {
            synchronized (key) {
                if (ticketNum > 0) {
                    System.out.println(getName() + "卖出了第" + ticketNum + "张票");
                    ticketNum--;
                } else {
                    System.out.println("票卖完了!");
                }
            }
        }
    }


}
