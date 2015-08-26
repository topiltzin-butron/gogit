package org.topiltzin.shibumi.gogit.interviews.giphy.dto;

public class SearchTerm {

	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return super.toString() + " " + term;
	}

}
