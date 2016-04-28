package cdio3.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import cdio3.client.gui.profile.*;
import cdio3.client.login.Login;
import cdio3.client.login.Startskaerm;
import cdio3.client.operatoerList.OperatoerList;
import cdio3.client.overlay.Banner;
import cdio3.client.overlay.MenuWidget;
import cdio3.client.temp.OperatorDTO;

/**
 * Main Class / Entry Point for client.
 */
public class MainClient implements EntryPoint 
{
	@Override
	public void onModuleLoad() {
		Composite page = null;
		
		OperatorDTO user1 = new OperatorDTO(13, "Lasse Holm Nielsen", "LHN", 2909911234L, "1234Abc", 1);
//		OperatorDTO user2 = new OperatorDTO(32, "Essal Mohl Lennise", "EML", 1990924321L, "cbA4321", 0);
//		page = new ViewProfile("Se Profil", user1);
//		page = new CreateProfile("Opret Profil");
//		page = new EditProfile("Rediger Profil", user2);
		
		//page = new OperatoerList();
		page = new Startskaerm();
		//page = new Login();
		
		
		RootPanel.get().add(page);
		
//		RootPanel.get().add(new Banner());
//		RootPanel.get().add(new MenuWidget());
		
	}
}