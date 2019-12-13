package com.we.test.train;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/10/29 8:06 下午
 */
public class Master {
    public static void main(String[] args) {
        Execute zjk = new Execute("张家口车站");
        Execute lf = new Execute("廊坊车站");
        Execute bj = new Execute("北京北车站");

        //让各个站台开始工作
        zjk.start();
        lf.start();
        bj.start();
    }
}
