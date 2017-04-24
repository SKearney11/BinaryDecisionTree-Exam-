

public class Rule {
	public int questionNumber;
	public String rule;
	public int yes;
	public int no;
	public Rule r_yes;
	public Rule r_no;
	
	
	public Rule(int questionNumber, String rule, int yes, int no, Rule r_yes, Rule r_no) {
		super();
		this.questionNumber = questionNumber;
		this.rule = rule;
		this.yes = yes;
		this.no = no;
		this.r_yes = r_yes;
		this.r_no = r_no;
	}


	public int getQuestionNumber() {
		return questionNumber;
	}




	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}




	public String getRule() {
		return rule;
	}




	public void setRule(String rule) {
		this.rule = rule;
	}




	public int getYes() {
		return yes;
	}




	public void setYes(int yes) {
		this.yes = yes;
	}




	public int getNo() {
		return no;
	}




	public void setNo(int no) {
		this.no = no;
	}




	public Rule getR_yes() {
		return r_yes;
	}




	public void setR_yes(Rule r_yes) {
		this.r_yes = r_yes;
	}




	public Rule getR_no() {
		return r_no;
	}




	public void setR_no(Rule r_no) {
		this.r_no = r_no;
	}
}
