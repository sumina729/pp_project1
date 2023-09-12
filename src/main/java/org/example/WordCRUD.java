package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{

    /*
        ArrayList<Word> wordList = new ArrayList<>();

        Word 클래스 내부 데이터 형태
        private int grade;
        private  String name;
        private  String meaning;

        wordList에 있는 정보를 wordList.txt 파일에 저장 하려고 하는데.

        public void saveWord(){

        }

        데이터 저장 포맷 : grade|name|meaning
        이렇게 저장 되도록

        위의 함수 안에 코드를 구현해줘



     */
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
        int num;
        System.out.print("삭제 할 단어 검색 : ");
        String keyWord = sc.next();

        ArrayList<Integer> idList = listWord(keyWord);

        if(idList.size()==0){
            System.out.println("검색하신 단어가 없습니다.");
            return;
        }




        while (true) {
            System.out.print("삭제 할 번호 선택 : ");
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


        System.out.print("정말로 삭제하실래요?(Y/n) ");
        sc.nextLine();
        String yes = sc.nextLine();

        while(true){
            if(yes.equals("Y") || yes.equals("y")){
                wordList.remove(num-1);
                System.out.println("단어가 삭제되었습니다.\n");
                break;
            }
            else if(yes.equals("N") || yes.equals("n")){
                break;
            }
        }


        return;
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

    public void searchWord(){

        System.out.print("단어 검색 : ");
        String keyWord = sc.next();

        ArrayList<Integer> idList = listWord(keyWord);
    }

    public void gradeWord(){

        System.out.print("난이도(1,2,3) 검색 : ");
        int num = sc.nextInt();

        System.out.println("\n--------------------------------");
        for(int i=0; i< wordList.size(); i++){

            int wordGrade = wordList.get(i).getGrade();
            if(wordGrade != num) continue;
            System.out.println( (i+1) + " " + wordList.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

    public void saveWord() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("wordList.txt"))) {
            for (Word word : wordList) {
                writer.println(word.saveString());

            }
            writer.close();
            System.out.println("파일 저장 성공");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }




    public void leadWord(){
        try (BufferedReader reader = new BufferedReader(new FileReader("wordList.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                wordList.add(Word.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(wordList.size() + "개의 단어를 읽어 왓습니다!\n");
    }


}
