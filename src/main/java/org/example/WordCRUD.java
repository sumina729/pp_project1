package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{

    ArrayList<Word> wordList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public Word add(){
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

        Word oneWord = add();
        wordList.add(oneWord);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!! \n");
    }

    @Override
    public int update(Object o){
        return 0;
    }

    public void updateItem(){
        int num;
        System.out.print("수정할 단어 검색 : ");
        String keyWord = sc.next();

        ArrayList<Integer> idList = listWord(keyWord);

        if(idList.size()==0){
            System.out.println("검색하신 단어가 없습니다.");
            return;
        }




        while (true) {
            System.out.print("수정할 번호 선택 : ");
             num = sc.nextInt();

            int c = 0;
            for(int i=0; i<idList.size(); i++){
                if(num == idList.get(i)) c = 1; // 선택한 번호가 있다면 1
            }
            if(c == 0){
                System.out.println("없는 번호입니다 다시 선택 해주세요");
            }
            else{
                break;
            }
        }


        System.out.print("뜻 입력 : ");
        sc.nextLine();
        String updateMeaning = sc.nextLine();

        wordList.get(num-1).setMeaning(updateMeaning);

        System.out.println("단어가 수정되었습니다.");
        return;

    }

    @Override
    public int delete(Object o){
        return 0;
    }

    public void deleteItem(){

    }

    @Override
    public void select(int id){

    }

    public void listAll(){
        //ArrayList<Integer> idList = new ArrayList<>();
        System.out.println("\n--------------------------------");
        for(int i=0; i< wordList.size(); i++){

            //String word = wordList.get(i).getName();
            //if(!word.contains(keyWord)) continue;

            System.out.println( (i+1) + " " + wordList.get(i).toString());
        }
        System.out.println("--------------------------------");

        return;
    }

    public ArrayList<Integer> listWord(String s){
        ArrayList<Integer> idList = new ArrayList<>();
        System.out.println("\n--------------------------------");
        for(int i=0; i< wordList.size(); i++){

            String word = wordList.get(i).getName();
            if(!word.contains(s)) continue;
            idList.add(i+1);
            System.out.println( (i+1) + " " + wordList.get(i).toString());
        }
        System.out.println("--------------------------------");

        return idList;
    }


}
