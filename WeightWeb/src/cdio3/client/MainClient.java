package cdio3.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import cdio3.client.gui.login.Startskaerm;
import cdio3.client.gui.overlay.Banner;
import cdio3.client.gui.profile.CreateProfile;
import cdio3.client.gui.profile.EditProfile;
import cdio3.client.gui.profile.ViewProfile;
import cdio3.client.service.ServiceClientImpl;
import cdio3.client.temp.OperatorDTO;

/**
 * Main Class / Entry Point for client.
 */
public class MainClient implements EntryPoint 
{
	@Override
	public void onModuleLoad() {
		ServiceClientImpl ClientImpl = new ServiceClientImpl(GWT.getModuleBaseURL() + "cdioservice");
		RootPanel.get().add(ClientImpl.getMainGUI());
		
		
		/*
		Composite page = null;
		
		OperatorDTO user1 = new OperatorDTO(13, "Lasse Holm Nielsen", "LHN", 2909911234L, "1234Abc", 1);
		OperatorDTO user2 = new OperatorDTO(32, "Essal Mohl Lennise", "EML", 1990924321L, "cbA4321", 0);
//		page = new ViewProfile("Se Profil", user1);
//		page = new CreateProfile("Opret Profil");
		page = new EditProfile("Rediger Profil", user2);
		
//		page = new OperatoerList();
//		page = new Startskaerm();

//		Banner banner = new Banner();
//		banner.setContentPanel(new ViewProfile("Se Profil", user1));
//		RootPanel.get().add(banner);
		
		//page = new Login();
		
		
		RootPanel.get().add(page);
	
	*/
	}
}