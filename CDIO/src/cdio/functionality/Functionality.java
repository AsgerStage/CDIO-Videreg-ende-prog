package cdio.functionality;

import cdio.models.OperatorDTO;


import java.util.ArrayList;
import java.util.List;

public class Functionality implements IFunctionality {

	List<OperatoerDTO> operatoerer= new ArrayList <OperatoerDTO>();

	public Functionality() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createOpr(String oprNavn, int cpr) { 
		// TODO Auto-generated method stub
		OperatoerDTO opr = new OperatoerDTO(oprId, oprNavn, ini, cpr, password); // Ny operator oprettes (der skal laves nogle metoder til at autogenerer oprId og ini )
		operatoerer.add(opr); // operator tilføjes en liste over operatører 
		return; // Her skal der returneres et oprId eller en ini-kode når operatøren er oprettet
	}

	@Override
	public boolean deleteOpr (int oprId) {
		// TODO Auto-generated method stub
		for(OperatoerDTO oprDTO: operatoerer){
			if(oprDTO.oprId==oprId){
				operatoerer.remove(oprDTO);
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateOpr(int oprId) {
		// TODO Auto-generated method stub
		for (){
			if (valg==1)//hvis det er navnet der skal ændres
				operatoerer.get(navn).setNavn();
			else if (valg==2)//hvis det er cpr der skal ændres
				operatoerer.get(cpr).setCpr();
			else if (valg==2)//hvis det er opr status der skal ændres
				operatoerer.get(oprStatus).setStatus();
		}
		// mulige ændringer
		// 1. Navn
		// 2. Cpr
		// 3. Status ( om det er en alm opr el admin )

	}

	@Override
	public boolean changePass(int oprId) {
		// TODO Auto-generated method stub
		for(OperatoerDTO oprDTO: operatoerer){
			if(oprDTO.oprId==oprId){
				operatoerer.get(password).setPassword();
				return true;
			}
		}
		return false;
	}
	double measure(int tara, int weight) {
		// TODO Auto-generated method stub
		return weight-tara;

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

}
