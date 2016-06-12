package edu.example.client.gui.profile;

public interface IProfilePage 
{
	public void setContent(String name, String initials, String cpr, int id, int rank);
	
	public String getName();
	
	public void setName(String name);
	
	public String getInitials();
	
	public void setInitials(String initials);
	
	public String getCPR();
	
	public void setCPR(String cpr);
	
	public int getID();
	
	public void setID(int id);
	
	public int getRank();
	
	public void setRank(int rank);
}