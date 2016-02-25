package cdio.functionality;

import cdio.data.IOperatorDAO;
import cdio.data.OperatorDAO;
import cdio.exceptions.DALException;
import cdio.models.OperatorDTO;
import java.util.List;
import java.util.Random;

public class Functionality implements IFunctionality {

	private List<OperatorDTO> operatoerer;
	private final IOperatorDAO dao;

	public Functionality(IOperatorDAO dao) {
		this.dao = dao;
		try {
			operatoerer = new OperatorDAO().getOperatorList();
			// TODO Auto-generated constructor stub
		} catch (DALException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public int createOpr(String oprNavn, int cpr, String ini, int rank) {
		// TODO Auto-generated method stub
		Random random = new Random();

		for (int i = 0; i < 20; i++) {

			int ran = random.nextInt(122 - 33) + 33;
			char kode = ((char) ran);

		}
		String pass = java.lang.String.valueOf("kode");

		OperatorDTO opr = new OperatorDTO(oprID, oprNavn, ini, cpr, pass, rank); // Ny

		operatoerer.add(opr); // operator tilf�jes en liste over operat�rer
		return oprID; // Her skal der returneres et oprID eller en ini-kode
		// n�r operat�ren er oprettet
	}

	private int generateID (){
		Random ID = new Random ();
		int newID;

		newID =11+ID.nextInt(89);

		if ( !operatoerer.contains(newID)){
			//operatoerer.add(newIni);
		}
		return newID;

	}



	@Override
	public boolean deleteOpr (int oprID) {
		// TODO Auto-generated method stub
		for(OperatorDTO oprDTO: operatoerer){
			if(oprDTO.getoprId()==oprID){
				operatoerer.remove(oprDTO);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateOpr(int oprID, String name, int cpr, int rank) {
		for(OperatorDTO oprDTO: operatoerer){
			if(oprDTO.getoprId()==oprID){

				OperatorDTO updatedOpr = oprDTO;
				if(name != null)
					oprDTO.setName(name);
				if(cpr != -1)
					oprDTO.setCpr(cpr);
				if(rank != -1)
					oprDTO.setRank(rank);

				try {
					dao.updateOperatoer(updatedOpr);
					return true;
				} catch (DALException ex) {
					ex.printStackTrace();
					return false;
				}
			}
		}
		return false;


	}

	@Override
	public boolean changePass(int oprID, String oldPassword, String newPassowrd1, String newPassword2) {
		// TODO Auto-generated method stub
		OperatorDTO opr;
		try {
			opr = dao.getOperator(oprID);

			if(newPassowrd1.equals(newPassword2)) {
				if(opr.getPassword().equals(oldPassword)) {
					opr.setPassword(newPassowrd1);
					return true;
				}
			}
		} catch (DALException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public double measure(double tara, double brutto) {
		// TODO Auto-generated method stub
		return brutto - tara;

	}

	@Override
	public boolean login(int userId, String password) {
		try {
			OperatorDTO opr = dao.getOperator(userId);
			if(opr != null)
				return opr.getPassword().equals(password);
		} catch (DALException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public OperatorDTO readOpr(int oprID) {
		try {
			return dao.getOperator(oprID);
		} catch (DALException e) {

			e.printStackTrace();
			return null;
		}
	}

}
