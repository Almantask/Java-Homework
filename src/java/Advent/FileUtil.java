package Advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{
	public static List<String> loadFile(String location)
	{
		File file = new File(location);
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader(file));
		} catch(FileNotFoundException e)
		{
			System.err.println("File not found!!");
			return new ArrayList<String>();
		}

		List<String> inputLines = new ArrayList<String>();
		try
		{
			String line;
			while((line = reader.readLine()) != null)
				inputLines.add(line);

			reader.close();
		} catch(IOException e)
		{
			e.printStackTrace();
		}

		return inputLines;
	}
}
