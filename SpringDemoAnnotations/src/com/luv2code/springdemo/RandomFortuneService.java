package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {"Today is good", "look behind you!", "that had to hurt"};
	//ArrayList is like an array that can grow
	private ArrayList<String> fileFortunes;
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		if(fileFortunes == null) {
			return fortunes[rand.nextInt(fortunes.length)];
		} else {
			return fileFortunes.get(rand.nextInt(fileFortunes.size()));
		}
		
	}
	
	@PostConstruct
	private void buildFortunes() {
		
		System.out.println("We're getting the fortunes with a postconstruct method!!!");
		// initialize the arraylist or yer gonna get a null pointer error
		fileFortunes = new ArrayList<String>();
				
		//seems like there's a better way to do this part...
		String fileName = "C:\\Users\\Josh\\eclipse-workspace\\SpringDemoAnnotations\\src\\fortune.txt";
		
		String line;
		
		try {
			// FileReader reads text files in the default encoding
			FileReader fileReader =
					new FileReader(fileName);
			
			// wrap FileReader in BufferedReader.
			// what does this do?
			BufferedReader bufferedReader =
					new BufferedReader(fileReader);
			
			//while the next line isn't empty add it to fortunes

			while((line = bufferedReader.readLine()) != null) {
				fileFortunes.add(line);
			}
			
			//close the buffer
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(">> buildFortunes: couldn't find fortune file");
		}
		catch(IOException ex) {
			System.out.println(">> buildFortunes: couldn't read the fortunes file");
		}
		
	}

}
