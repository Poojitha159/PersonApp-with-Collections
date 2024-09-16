package com.techlabs.model;

public class Person {

	 private String personName;
	    private int personAge;
	    private String personAddress;

	    public Person(String personName, int personAge, String personAddress) {
	        this.personName = personName;
	        this.personAge = personAge;
	        this.personAddress = personAddress;
	    }

	    public String getPersonName() {
	        return personName;
	    }

	    public void setPersonName(String personName) {
	        this.personName = personName;
	    }

	    public int getPersonAge() {
	        return personAge;
	    }

	    public void setPersonAge(int personAge) {
	        this.personAge = personAge;
	    }

	    public String getPersonAddress() {
	        return personAddress;
	    }

	    public void setPersonAddress(String personAddress) {
	        this.personAddress = personAddress;
	    }

	    @Override
	    public String toString() {
	        return "[Name=" + personName + ", Age=" + personAge + ", Address=" + personAddress + "]";
	    }
    
    
    
}
