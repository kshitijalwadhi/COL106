public class program {
	public String[] test(String fileNames[]) {
		/*
		 * Exercise 16: Java files- You have been given the list of the names of the
		 * files in a directory. You have to select Java files from them. A file is a
		 * Java file if it’s name ends with ”.java”. For e.g. ”File-Names.java” is a
		 * Java file, ”FileNames.java.pdf” is not. If the input is
		 * {”can.java”,”nca.doc”,”and.java”,”dan.txt”,”can.java”,”andjava.pdf”} the
		 * expected output is {”can.java”,”and.java”,”can.java”}
		 */

		int new_length = 0;
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".java")) {
				new_length++;
			}
		}
		String javaFiles[] = new String[new_length];
		int j = 0;
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".java")) {
				javaFiles[j] = fileNames[i];
				j++;
			}
		}

		return javaFiles;
	}
}
