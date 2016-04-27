package cdio3.client.gui.profile;

public interface ProfilePanel 
{
	public void setContent(String name, String initials, long cpr, int id, String rank);
	
	public String getName();
	
	public void setName(String name);
	
	public String getInitials();
	
	public void setInitials(String initials);
	
	public long getCPR();
	
	public void setCPR(long cpr);
	
	public int getID();
	
	public void setID(int id);
	
	public String getRank();
	
	public void setRank(String rank);
}