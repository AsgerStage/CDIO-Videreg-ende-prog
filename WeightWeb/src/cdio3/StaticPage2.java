package cdio3;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StaticPage2 extends Composite{

	private VerticalPanel vPanel= new VerticalPanel();

	public StaticPage2(){
		initWidget(this.vPanel);


		vPanel.setBorderWidth(1);

		MenuBar menu = new MenuBar(true);
		menu.addItem(new MenuItem("Ny afvejning", cmd_NewWeight));
		menu.addItem(new MenuItem("Min side", cmd_Profile));
		menu.addItem(new MenuItem("Soeg", cmd_Search));
		menu.addItem(new MenuItem("Hjem", cmd_Home));
		menu.addItem(new MenuItem("Afslut", cmd_Exit));

		vPanel.add(menu);

	}
	// Kommandoer der ekskiveres når der bliver klikket på et menu punkt
	Command cmd_NewWeight = new Command(){

		public void execute() {
			xx.openNewWeight(); 
		}
	};

	Command cmd_Profile = new Command(){

		public void execute() {
			xx1.openProfile(); 
		}
	};

	Command cmd_Search = new Command(){

		public void execute() {
			xx2.openSearch();
		}
	};
	Command cmd_Home = new Command(){

		public void execute() {
			xx3.openHome();
		}
	};
	Command cmd_Exit = new Command(){

		public void execute() {
			xx4.openExit();
		}
	};
}