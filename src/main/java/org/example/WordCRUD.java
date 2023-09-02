package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{

    private ArrayList wordList = new ArrayList<Word>();

    @Override
    public int add(){
        int addGrade;
        String addName;
        String addMeaning;

        Word addWord = new Word();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
        addGrade = sc.nextInt();
        addName = sc.next();

        sc.nextLine();
        System.out.print("뜻 입력 : ");
        addMeaning = sc.nextLine();

        addWord.setGrade(addGrade);
        addWord.setName(addName);
        addWord.setMeaning(addMeaning);

        wordList.add(addWord);

        System.out.println("새 단어가 단어장에 추가되었습니다 !!! \n");


        return 1;
    }
    @Override
    public int update(){
        return 0;
    }

    @Override
    public int delete(){
        return 0;
    }

    @Override
    public void select(Object o){

    }

}
