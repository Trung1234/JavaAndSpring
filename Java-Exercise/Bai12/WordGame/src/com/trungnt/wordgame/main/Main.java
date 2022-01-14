package com.trungnt.wordgame.main;

import com.trungnt.wordgame.mange.WordManager;
import com.trungnt.wordgame.model.Word;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by My PC on 06/11/2017.
 */
public class Main {
	public static void main(String[] args) {
		WordManager wordManager = new WordManager("Thể Thao");
		wordManager.addWord("Sport","Thể Thao");
		wordManager.addWord("Soccer","Bóng đá");
		wordManager.addWord("Football","Bóng đá");
		wordManager.addWord("Leg","Chân");
		wordManager.addWord("Defender","Hậu vệ");
		wordManager.printAllWord();
		Word[] twoWords = wordManager.getTwoWordRandom();
		System.out.println(Arrays.toString(twoWords));
	}
}

