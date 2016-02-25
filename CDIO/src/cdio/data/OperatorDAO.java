package cdio.data;

import cdio.exceptions.DALException;
import cdio.models.OperatorDTO;
import java.util.ArrayList;
import java.util.List;

public class OperatorDAO implements IOperatorDAO {

	ArrayList<OperatorDTO> Oplist = new ArrayList<>();
	
	public OperatorDAO() {
            Oplist.add(new OperatorDTO(99, "Admin", "Abc0234", 0000000000L, "Abc0234", 1));
            Oplist.add(new OperatorDTO(11, "Lasse H Nilesen", "LHN", 2909912191L, "1122", 0));
	}

	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		for(int i=0;i<Oplist.size();i++)
		{
			if (Oplist.get(i).getoprID()==oprId)
				return Oplist.get(i);
		}
		return null;
	}

	@Override
	public List<OperatorDTO> getOperatorList() throws DALException {
		// TODO Auto-generated method stub
		return Oplist;
	}

	@Override
	public void createOperatoer(OperatorDTO opr) throws DALException {
		Oplist.add(opr);
		
	}

	@Override
	public void updateOperatoer(OperatorDTO opr) throws DALException {
		
		OperatorDTO temp = opr;
		deleteOperatoer(opr);
		createOperatoer(temp);
		
		
	}

    @Override
    public void deleteOperatoer(OperatorDTO opr) throws DALException {
        ArrayList<OperatorDTO> tempList = (ArrayList<OperatorDTO>) Oplist.clone();
        for (OperatorDTO operatoer : tempList) {
            if(opr.getoprID() == operatoer.getoprID())
                Oplist.remove(operatoer);
        }
    }
}
