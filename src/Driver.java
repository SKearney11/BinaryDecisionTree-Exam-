import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	ArrayList<Rule> rules = new ArrayList();
	Scanner sc = new Scanner(System.in);
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Driver().run();
	}
	
	void run(){
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		createTree();
		askQuestions(1);
	}
	
	//Recursive method for asking questions
	void askQuestions(int num)
	{
		//until we get to the end of the rules keep requesting an answer and recursivly feed it back into this method
		while(num < rules.size())
		{
			num -=1;
			//print the rule
			System.out.println(rules.get(num).getRule());
			String answer = scan.next();
			//if the answer is yes run the function again where num is the yes field in the question
			if(answer.equals("yes"))
			{
				askQuestions(rules.get(num).getR_yes().getQuestionNumber());
			}else if(answer.equals("no"))
			{
				askQuestions(rules.get(num).getR_no().getQuestionNumber());
			}
			else{
				//making sure user enters a valid answer
				System.out.println("Enter yes or no");
				askQuestions(num);
			}
		}
		//print the final rule
		System.out.println(rules.get(num-1).getRule());
		System.out.println("Program will now close");
		System.exit(0);
	}
	
	
	void readFile() throws IOException
	{
		//simply reading in file and adding to an arraylist
		File userFile = new File("/Users/seankearney/Documents/DataStructures/DecisionTree/src/Data/Rules");
		Scanner ruleFile = new Scanner(userFile);
		String delims = "[:]";
        while(ruleFile.hasNextLine())
        {
        	int yes = 0;
        	int no = 0;
        	String rule = ruleFile.nextLine();
        	String[] ruleTokens = rule.split(delims);
        	int questionNumber = Integer.parseInt(ruleTokens[0]);
        	String question = ruleTokens[1];
        	if(ruleTokens.length > 2){
        		yes = Integer.parseInt(ruleTokens[2]);
        	}
        	if(ruleTokens.length > 3)
        	{
        		no = Integer.parseInt(ruleTokens[3]);
        	}
        	//two null feilds for yes and no objects. they will be added later in the createTree function
        	rules.add(new Rule(questionNumber, question, yes, no, null, null));
        }
	}
	
	//links the nodes of the tree by comparing the yes/no field with the rule numbers
	void createTree(){
		for(int i= 0; i < rules.size(); i++)
		{
			for(int k = 0; k < rules.size(); k++)
			{
				if(rules.get(i).getYes() == rules.get(k).getQuestionNumber())
				{
					rules.get(i).setR_yes(rules.get(k));
				}
				if(rules.get(i).getNo() == rules.get(k).getQuestionNumber())
				{
					rules.get(i).setR_no(rules.get(k));
				}
			}
		}
	}
}
