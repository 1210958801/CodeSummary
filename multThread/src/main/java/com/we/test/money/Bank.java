package com.we.test.money;

/**
 * @Description: 取钱测试->两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/10/29 8:14 下午
 */
public class Bank {

    /**
     * 钱数量
     */
    public static Double money = 20000D;

    /**
     * 提供一个ATM机的取钱方式
     */
    public void atm(double atmM) {
        money -= atmM;
        System.out.println("atm机取钱" + atmM + "余额还有:" + money);
    }

    /**
     * 提供一个柜台取钱的方式
     */
    public void counter(double counterM) {
        money -= counterM;
        System.out.println("柜台机取钱" + counterM + "余额还有:" + money);
    }

    public synchronized void outMoney(String outType, double outMoney) {
        if (outMoney > Bank.money) {
            throw new RuntimeException("您要取的钱大于余额");
        } else {
            if (("atm").equals(outType)) {
                atm(outMoney);
            } else {
                counter(outMoney);
            }
        }
    }
}
