package com.yiliang;

import java.util.Random;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        //双色球
        int[] userNumbers=userSelectNumbers();
        System.out.print("您投注的号码为：");
        printArray(userNumbers);
        int[] luckNumbers=createLuckNumbers();
        System.out.print("中奖号码为：");
        printArray(luckNumbers);
        System.out.println();
        judge(userNumbers,luckNumbers);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i==arr.length-1? arr[i]:arr[i]+",");
        }
        System.out.println("]");
    }//打印数组

    //设计方法让用户投注一组号码并返回
    public static int[] userSelectNumbers() {
        //创建整型数组用于存储号码
        int[] numbers=new int[7];
        Scanner sc=new Scanner(System.in);

        //遍历前六个位置让用户一次投注前六个红球号码
        for (int i = 0; i < numbers.length-1; i++) {
            while (true) {
                System.out.println("请输入第"+(i+1)+"个红球号码（1-33之间，不能重复：）");
                int number=sc.nextInt();
                //判断数据合法性
                if (number<1||number>33)
                {
                    System.out.println("对不起，您输入的红球号码不在1-33之间，请确认！\n");
                }
                else
                {
                    if (exist(numbers,number)) {
                        System.out.println("您当前选择号码重复，请重新选择！\n");
                    }
                    else
                    {
                        numbers[i]=number;
                        break;
                    }
                }
            }
        }
        while (true) {
            //录入篮球号码
            System.out.println("请您输入篮球号码（1-16）：");
            int number=sc.nextInt();
            if(number<1||number>16)
            {
                System.out.println("对不起，您输入的篮球号码范围不对！\n");
            }
            else
            {
                numbers[6]=number;
                break;
            }
        }
        return numbers;
    }//用户选择号码

    public static boolean exist(int[] numbers, int number) {
        //判断number是否在numbers中存在
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==0)
            {
                break;
            }
            if (numbers[i]==number)
            {
                return true;
            }
        }
        return false;
    }//判断重复

    public static int[] createLuckNumbers() {
        //1、创建整型数组存储7个号码
        int[] numbers=new int[7];
        Random r=new Random();

        //2、遍历前六个数字，一次随机一个红球号码存入（1-33，不重复）
        for (int i = 0; i < numbers.length-1; i++) {
            while (true) {
                //3、为当前i随机一个红球数字
                int number=r.nextInt(33)+1;
                //4、判断是否重复
                if (exist(numbers,number)) {
                }
                else
                {
                    numbers[i]=number;
                    break;
                }
            }
        }
        //5、录入篮球号码
        numbers[6]=r.nextInt(16)+1;
        return numbers;
    }//随机生成中奖号码

    public static void judge(int[] userNumbers,int[] luckNumbers) {
        //定义两个变量用于记住红球命中了几个，篮球命中了几个
        int redCount=0,blueCount=0;
        //判断红球命中的数量
        for (int i = 0; i < userNumbers.length-1; i++) {
            for (int j = 0; j < luckNumbers.length-1; j++) {
                if (userNumbers[i]==luckNumbers[j])
                {
                    redCount++;
                    break;
                }
            }
        }
        //判断篮球是否命中
        blueCount=userNumbers[6]==luckNumbers[6]? 1:0;

        System.out.println("您命中了"+redCount+"个红球，"+blueCount+"个蓝球。\n");
        if (redCount==6&&blueCount==1)
        {
            System.out.println("恭喜您，中奖1000万，可以开始享受人生了！");
        }else if (redCount==6&&blueCount==0)
        {
            System.out.println("恭喜您，中奖500万，可以稍微开始享受人生了！");
        }else if (redCount==5&&blueCount==1)
        {
            System.out.println("恭喜您，中奖3000元，可以出去吃顿小龙虾了！");
        }else if (redCount==5&&blueCount==0||redCount==4&&blueCount==1)
        {
            System.out.println("恭喜您，中奖200元！");
        }else if (redCount==4&&blueCount==0||redCount==3&&blueCount==1)
        {
            System.out.println("恭喜您，中奖10元！");
        }else if (redCount<3&&blueCount==1)
        {
            System.out.println("恭喜您，中奖5元！");
        }else
        {
            System.out.println("感谢您对福利事业作出的巨大贡献！");
        }
    }//判断中奖
}
