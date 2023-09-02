package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{

    ArrayList wordList = new ArrayList<Word>();
    Scanner sc = new Scanner(System.in);

    @Override
    public Object add(){
        int addGrade;
        String addName;
        String addMeaning;


        System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
        addGrade = sc.nextInt();
        addName = sc.next();

        sc.nextLine();
        System.out.print("뜻 입력 : ");
        addMeaning = sc.nextLine();

        return new Word(0, addGrade, addName, addMeaning);


    }

    public void wordAdd(){

        Word oneWord = (Word)add();
        wordList.add(oneWord);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!! \n");
    }

    @Override
    public int update(Object o){
        return 0;
    }

    @Override
    public int delete(Object o){
        return 0;
    }

    @Override
    public void select(int id){

    }

    public  void listAll(){
        System.out.println("\n--------------------------------");
        for(int i=0; i< wordList.size(); i++){
            System.out.println( (i+1) + " " + wordList.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

}
