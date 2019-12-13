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
public class PeopleA extends Thread {
    private String outType;
    private double outMoney;
    private Bank bank;

    public PeopleA(double outMoney, String outType, Bank bank) {
        this.outMoney = outMoney;
        this.outType = outType;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            try {
                bank.outMoney("atm", 100);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
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
