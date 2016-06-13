package edu.example.client.weightPage;

import java.util.ArrayList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.exceptions.DALException;
import edu.example.client.models.OperatorDTO;
import edu.example.client.models.ProduktbatchDTO;
import edu.example.client.models.ProduktbatchkompDTO;
import edu.example.client.models.RaavarebatchDTO;
import edu.example.client.models.ReceptDTO;
import edu.example.client.service.RPCServiceClientImpl;


public class WeightPage extends Composite 
{
	private HorizontalPanel mainPanel = new HorizontalPanel();
	private RPCServiceClientImpl serverComm;
		
	private TextArea messageWindow = new TextArea();
	private TextBox display;
	private final String displayDefaultText = "0";
	
	private int state = 0;
	private OperatorDTO currentUser;
	private ProduktbatchDTO currentPB;
	private ReceptDTO currentRecept;
	private RaavarebatchDTO currentRB;
	private double tara = 0.0;
	private double netto = 0.0;

	public WeightPage(RPCServiceClientImpl serverComm) {
		this.serverComm = serverComm;
		initWidget(mainPanel);

		init();
	}

	public void init() {
		VerticalPanel keypadPanel = new VerticalPanel();
		display = new TextBox();
		display.setEnabled(false);
		display.setText(displayDefaultText);

		Grid grid = new Grid(4, 3);
		Button bt0 = new Button("0");
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button bt4 = new Button("4");
		Button bt5 = new Button("5");
		Button bt6 = new Button("6");
		Button bt7 = new Button("7");
		Button bt8 = new Button("8");
		Button bt9 = new Button("9");

		bt0.addClickHandler(new KeypadClickHandler());
		bt1.addClickHandler(new KeypadClickHandler());
		bt2.addClickHandler(new KeypadClickHandler());
		bt3.addClickHandler(new KeypadClickHandler());
		bt4.addClickHandler(new KeypadClickHandler());
		bt5.addClickHandler(new KeypadClickHandler());
		bt6.addClickHandler(new KeypadClickHandler());
		bt7.addClickHandler(new KeypadClickHandler());
		bt8.addClickHandler(new KeypadClickHandler());
		bt9.addClickHandler(new KeypadClickHandler());
		
		Button btClear = new Button("Clear");
		Button btEnter = new Button("Enter");
		
		btClear.addClickHandler(new ClearClickHandler());
		btEnter.addClickHandler(new ButtonEnterClickHandler());
		
		grid.setWidget(0, 0, bt7);
		grid.setWidget(0, 1, bt8);
		grid.setWidget(0, 2, bt9);
		grid.setWidget(1, 0, bt4);
		grid.setWidget(1, 1, bt5);
		grid.setWidget(1, 2, bt6);
		grid.setWidget(2, 0, bt1);
		grid.setWidget(2, 1, bt2);
		grid.setWidget(2, 2, bt3);
		grid.setWidget(3, 0, btClear);
		grid.setWidget(3, 1, bt0);
		grid.setWidget(3, 2, btEnter);
		
		messageWindow.setSize("100%", "100%");
		messageWindow.setEnabled(false);

		keypadPanel.add(display);
		keypadPanel.add(grid);
		
		mainPanel.add(keypadPanel);
		mainPanel.add(messageWindow);
		
		run();
	}
	
	private void run() {
		switch (state) {
			case 0: {
				currentPB = null;
				currentRB = null;
				currentRecept = null;
				currentUser = null;
				messageWindow.setText("Indtast operatoer nummer");
				break;
			}
			case 1: {
				messageWindow.setText("Er du " + currentUser.getName() 
				+ "? \nIndtast 1 for ja og 0 for nej");
				break;
			}
			case 2: {
				messageWindow.setText("Indtast et produktbatch nummer");
				break;
			}
			case 3: {
				try {
					currentPB.setStatus(1);
					serverComm.updateProduktbatch(currentPB);
					messageWindow.setText("Recept: " + currentRecept.getReceptNavn()
						+ "\nFjern alt fra vaegten og placer beholderen paa vaegten"
						+ "\nTryk herefter paa \"Enter\" for at veje indpakningen");
				} catch (DALException e) {
					e.printStackTrace();
					messageWindow.setText(e.getMessage());
				}
				break;
			}
			case 4: {
				messageWindow.setText("Recept: " + currentRecept.getReceptNavn()
					+ "\nTara: " + tara + " kg"
					+ "\nIndtast raavarebatch nummer paa den raavare som skal vejes");
				break;
			}
			case 5: {
				messageWindow.setText("Recept: " + currentRecept.getReceptNavn()
					+ "\nTara: " + tara + " kg"
					+ "\nRaavarebatch: " + currentRB.getRbID() + ", " + currentRB.getRaavare().getRaavareNavn()
					+ "\nPlacer den oenskede maenge af raavaren paa vaegten og tryk \"Enter\"");
				break;
			}
			default: {
				messageWindow.setText("Noget gik galt. Proev at genindlaese siden");
				break;
			}
		}
	}
	
	private class KeypadClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			if(event.getSource() instanceof Button) {
				Button button = (Button) event.getSource();
				
				if(display.getText().equals(displayDefaultText)) 
					display.setText(button.getText());
				else
					display.setText(display.getText() + button.getText());
			}
		}		
	}
	
	private class ClearClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {
			display.setText(displayDefaultText);
		}		
	}

	private class ButtonEnterClickHandler implements ClickHandler 
	{
		@Override
		public void onClick(ClickEvent event) {	
			switch (state) {
				case 0: {
					serverComm.getOperator(Integer.parseInt(display.getText()));
					state = 1;
					break;
				}
				case 1: {
					int confirm = Integer.parseInt(display.getText());
					if(confirm == 1) {
						state = 2;
						display.setText(displayDefaultText);
						run();
					}
					else {
						currentUser = null;
						state = 0;
						run();
					}
					break;
				}
				case 2: {
					serverComm.getProduktbatch(Integer.parseInt(display.getText()));
					state = 3;
					break;
				}
				case 3: {
					serverComm.getData("S", new ArrayList<String>());
					break;
				}
				case 4: {
					serverComm.getRaavarebatch(Integer.parseInt(display.getText()));
					state = 5;
					break;
				}
				case 5: {
					serverComm.getData("S", new ArrayList<String>());
					break;
				}
				case 6: {
					int confirm = Integer.parseInt(display.getText());
					if(confirm == 1) {
						state = 3;
						run();
					}
					else {
						try {
							currentPB.setStatus(2);
							serverComm.updateProduktbatch(currentPB);
							state = 0;
							run();
						} 
						catch (DALException e) {
							messageWindow.setText("Error: " + e);
						}
					}
					break;
				}
				default: {
					messageWindow.setText("Noget gik galt i indtastningen");
					break;
				}
			}
		}
	}

	public void displayData(String input) {
		switch (state) {
			case 3: {
				tara = Double.parseDouble(input);
				messageWindow.setText(messageWindow.getText() + "\nTara = " + tara + " kg");
				state = 4;
				run();
				break;
			}
			case 5: {
				try {
					display.setText(displayDefaultText);
					netto = Double.parseDouble(input);
					serverComm.createPbkomp(new ProduktbatchkompDTO(currentPB.getPbID(), currentRB.getRbID(), tara, netto, currentUser.getOprID()));
					messageWindow.setText("Recept: " + currentRecept.getReceptNavn()
						+ "\nTara: " + tara + " kg"
						+ "\nRaavarebatch: " + currentRB.getRbID() + ", " + currentRB.getRaavare().getRaavareNavn()
						+ "\nRaavare: " + (netto - tara) + " kg"
						+ "\nVil du foretage en ny afvejning? 1 = ja, 0 = nej");
					state = 6;
				} 
				catch (DALException e) {
					messageWindow.setText(e.getMessage());
				};				
				break;
			}
			default: {
				messageWindow.setText(input);
				break;
			}
		}
	}

	public void setCurOpr(OperatorDTO opr) {
		currentUser = opr;
		display.setText(displayDefaultText);
		run();
	}

	public void setCurPB(ProduktbatchDTO pb) {
		currentPB = pb;
		messageWindow.setText(messageWindow.getText() + "\n\nHenter recept");
		serverComm.getRecept(pb.getReceptID());
	}

	public void setCurRecept(ReceptDTO recept) {
		currentRecept = recept;
		display.setText(displayDefaultText);
		run();
	}

	public void setCurRB(RaavarebatchDTO rb) {
		currentRB = rb;
		run();
	}
}