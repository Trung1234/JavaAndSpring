package com.trungnt.wordgame.mange;

import com.trungnt.wordgame.model.Word;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by My PC on 06/11/2017.
 */
public class WordManager {
	private ArrayList<Word> listWord;
	private String category;
	
	public WordManager(String category) {
		this.category = category;
		listWord = new ArrayList<>();
	}
	public void addWord(String word, String vnMean){
		Word wordObj = new Word(word, vnMean);
		if(!listWord.contains(wordObj)){
			listWord.add(wordObj);
		}
	}
	public Word[] getTwoWordRandom(){
		Collections.shuffle(listWord);
		Word arrWord[] = new Word[2];
		arrWord[0] = listWord.get(0);
		arrWord[1] = listWord.get(1);
		return arrWord;
	}
	public void remove(String word){
		for (int i=0;i<listWord.size();i++){
			if(listWord.get(i).getWord().equals(word)){
				listWord.remove(i);
				return;
			}
		}
	}
	public void printAllWord(){
		System.out.println("Category :"+category);
		System.out.println(listWord.toString());
	}
}
