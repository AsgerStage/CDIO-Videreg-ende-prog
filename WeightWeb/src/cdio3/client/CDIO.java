package cdio3.profile.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

import cdio3.profile.client.gui.profile.*;
import cdio3.profile.client.models.User;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CDIO implements EntryPoint 
{	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ProfilePage page;
		User user1 = new User("Lasse Holm Nielsen", "LHN", 2909912191L, 24, User.RANK_ADMIN);
		User user2 = new User("Sofie Marie Slott Thorborg", "SST", 106911234L, 25, User.RANK_OPR);
		
//		page = new ViewProfile("Se Profil", user1);
//		page = new CreateProfile("Opret Profil");
		page = new EditProfile("Rediger Profil", user2);
		
		RootPanel.get().add(page);
	}
}