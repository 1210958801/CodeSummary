package com.we.test.money;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/10/29 8:35 下午
 */
@Setter
@Getter
public class PeopleB extends Thread {
    private String outType;
    private double outMoney;
    private Bank bank;

    public PeopleB(double outMoney, String outType, Bank bank) {
        this.outMoney = outMoney;
        this.outType = outType;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money > 200) {
            try {
                bank.outMoney("counter", 200);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
