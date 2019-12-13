package com.we.test.money;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/10/29 8:39 下午
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        PeopleA peopleA = new PeopleA(100, "atm", bank);
        PeopleB peopleB = new PeopleB(200, "counter", bank);

        peopleA.start();
        peopleB.start();
    }
}
