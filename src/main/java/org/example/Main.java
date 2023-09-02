package org.example;

public class Main {
    public static void main(String[] args) {
        WordManager wordManager = new WordManager();
        WordCRUD wordCRU = new WordCRUD();


        while (true){
            int selectNum = wordManager.selectMenu();
            if(selectNum == 0) {
                System.out.println("> 시스템을 종료합니다. <\n");
                break;
            }
            switch(selectNum) {
                case 1:

                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    wordCRU.add();
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                default :
                    System.out.println("> 숫자를 다시 입력해주세요. <\n");
            }

        }

        //System.out.println("Hello world!");
    }
}