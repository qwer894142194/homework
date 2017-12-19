package main;

import ResLog.Login;
import ResLog.Resgiter;
import game.Game;
import tool.MessageTen;
import tool.Phone;
import tool.Wea;

import java.util.Scanner;

public class Main {

    private  static final int REGISTER_CODE = 1;
    private  static final int LOGIN_CODE = 2;


    public static void main(String[] args) throws Exception {
        System.out.println("欢迎来到-----");
        while(true) {
            System.out.println("请选择: 1.注册  2.登录  0.选择功能"
            );

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case REGISTER_CODE:
                    Resgiter.resgiter();
                    break;
                case LOGIN_CODE:
                    Login.login();
                    break;
            }
                 if(choice ==0){
                         break;
                     }
        }
                while (true) {
                    System.out.println("1. 查询天气 2.查询手机号归属地  3.查询手速游戏前十用户 4.手速游戏   请选择");
                    Scanner input1 = new Scanner(System.in);
                    int choice2 = input1.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.println("请输入城市拼音");
                            Scanner input = new  Scanner(System.in);
                            String city  = input.nextLine();
                            Wea wea = new Wea();
                            wea.Test(city);
                            break;
                        case 2:
                            System.out.println("请输入手机号");
                            Scanner input2 = new  Scanner(System.in);
                            String phoneNum  = input2.nextLine();
                            Phone.Test(phoneNum);
                            break;
                        case 3:
                            MessageTen.Test();
                            break;
                        case 4:
                            System.out.println("选择游戏模式 1.简单  2.中等 3.困难");
                            Scanner sc = new Scanner(System.in);
                            Game game = new Game();

                               game: while(true) {
                                    int choice3 = sc.nextInt();
                                   Game.start();
                                    if (choice3 == 1) {
                                        game.easy();
                                        break game;

                                    }
                                    if (choice3 == 2) {
                                        game.middle();
                                        break game;
                                    }
                                    if (choice3 == 3) {
                                        game.diffcult();
                                        break game;
                                    } else {
                                        System.out.println("选择错误,请重新选择");
                                        continue game;
                                    }
                                }
                            break;

                    }
                }
        }
}
