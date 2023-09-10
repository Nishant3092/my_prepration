package com.learnanyhow.nish;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Problem {

	public static void main(String[] args) {

		List<Entry> list = sortByValueInDecreasingOrder(buildWordMap(null)); 
		System.out.println("List of repeated word from file and their count");
		for (Entry entry : list) { 
			
			} 
		}

	

	
	
	//Method - 1
	public static Map<String, Integer> buildWordMap(String fileName) {

		// Using diamond operator for clean code
		Map<String, Integer> wordMap = new HashMap<>();

		// Using try-with-resource statement for automatic resource management
		try (FileInputStream fis = new FileInputStream(fileName);
				DataInputStream dis = new DataInputStream(fis);
				BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {

			// words are separated by whitespace
			Pattern pattern = Pattern.compile("\\s+");
			String line = null;

			while ((line = br.readLine()) != null) {

				// do this if case sensitivity is not required i.e. Java = java
				line = line.toLowerCase();
				String[] words = pattern.split(line);
				for (String word : words) {
					if (wordMap.containsKey(word)) {
						wordMap.put(word, (wordMap.get(word) + 1));
					} else {
						wordMap.put(word, 1);
					}
				}
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		return wordMap;
	}







//Method - 2
public static List<Entry> sortByValueInDecreasingOrder(Map<String, Integer> wordMap){
	
	
	Set<java.util.Map.Entry<String,Integer>> entries = wordMap.entrySet();
	

	

	return null ;
}
}