import java.util.ArrayList;
import java.util.List;

public class OperatorDAO implements IOperatorDAO {

	ArrayList<OperatorDTO> Oplist = new ArrayList<OperatorDTO>();
	
	public OperatorDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		for (int i=0;i<Oplist.size();i++)
		{
			if (Oplist.get(i).getoprId()==oprId)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOperatoer(OperatorDTO opr) throws DALException {
		Oplist.remove(opr);
		
	}

	
}
