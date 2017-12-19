package game;

import tool.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
    在开始字样显示后，一直到用户输入完信息，提供给用户一个计算的时间。
    将用户的游戏时间，和用户信息通过网址（注1）提交。
    score的单位为毫秒
    注意下面通过?和&提交信息的写法
    http://(注1)?username=zhangSan&score=102
    并且提供给用户当前最快的用户是谁，通过提供的网址获得
 */
public class Game {



    public static void start(){
        for (int i = 3; i >0 ; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("倒计时"+i + "秒钟后开始");
        }

    }

    //游戏模式
    //简单模式
            public void easy() throws IOException {
                long start= System.currentTimeMillis();
                String easy = "qwertyuiopasdfghjklzxcvbnm1234567890";
                String newEasy ="";
                for (int i = 0; i <10 ; i++) {
                        int index= (int) (Math.random()*(35-0+1) + 0);
                        newEasy+=easy.charAt(index);
                }
                System.out.println(newEasy);

                Scanner scanner = new Scanner(System.in);
                String player = scanner.nextLine();



                if(newEasy.equals(player)){
                    System.out.println("闯关成功");
                    long end= System.currentTimeMillis();

                   int Score = (int) (end - start);
                    System.out.println("闯关分数是: " + Score);
                    Message.Test();

                }else{
                    System.out.println("闯关失败,下次继续加油!");
                }
            }

    //中等模式
            public void middle() throws IOException {
                Long start= System.currentTimeMillis();
                String middle ="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String newMiddle ="";
                for (int i = 0; i <20 ; i++) {
                    int index= (int) (Math.random()*(61-0+1) + 0);
                    newMiddle+=middle.charAt(index);
                }
                System.out.println(newMiddle);

                Scanner scanner = new Scanner(System.in);
                String player = scanner.nextLine();


                if(newMiddle.equals(player)){
                    System.out.println("闯关成功");
                    Long end= System.currentTimeMillis();
                    int Score = (int) (end - start);
                    System.out.println("闯关分数是: " + Score);
                    Message.Test();
                }else{
                    System.out.println("闯关失败");
                }
            }

    //困难模式
            public void diffcult() throws IOException {
                Long start= System.currentTimeMillis();
                String diffcult="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!~@#$%^&*(){}[]/.,<>?+-*/";
                String newDiffcult ="";
                for (int i = 0; i <30 ; i++) {
                    int index= (int) (Math.random()*(86-0+1) + 0);
                    newDiffcult+=diffcult.charAt(index);
                }
                System.out.println(newDiffcult);

                Scanner scanner = new Scanner(System.in);
                String player = scanner.nextLine();

                if(newDiffcult.equals(player)){
                    System.out.println("闯关成功");
                    Long end= System.currentTimeMillis();
                    int Score = (int) (end - start);
                    System.out.println("闯关分数是: " + Score);
                    Message.Test();
                }else{
                    System.out.println("闯关失败");
                }
            }



}
