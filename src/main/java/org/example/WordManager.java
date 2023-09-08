package org.example;

import java.util.Scanner;

public class WordManager {

    public void start(){
        WordCRUD wordCRUD = new WordCRUD();
        System.out.println("*** 영단어 마스터 ***\n");
        while (true){
            int selectNum = selectMenu();
            if(selectNum == 0) {
                System.out.println("프로그램 종료! 다음에 만나요~");
                break;
            }
            switch(selectNum) {
                case 1:
                    wordCRUD.listAll();
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    wordCRUD.wordAdd();
                    break;

                case 5:
                    wordCRUD.updateItem();
                    break;

                case 6:
                    break;

                case 7:
                    break;

                default :
                    System.out.println("> 숫자를 다시 입력해주세요. <\n");
            }

        }
    }

    public int selectMenu(){

        int selectNum;
        Scanner sc = new Scanner(System.in);

        System.out.print(
                "********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "********************\n" +
                "=> 원하는 메뉴는? "
        );

        selectNum = sc.nextInt();
        return selectNum;
    }
}
