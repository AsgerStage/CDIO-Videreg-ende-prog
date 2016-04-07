package cdio.data;
import cdio.exceptions.DALException;
import cdio.exceptions.OpIdException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;

import java.util.ArrayList;
import java.util.List;

public class OperatorDAO implements IOperatorDAO 
{
    private final ArrayList<OperatorDTO> oprList = new ArrayList<>();

    public OperatorDAO() {
        try {
            oprList.add(new OperatorDTO(99, "Admin", "ADM", 0000000000L, "Abc0234", 1));
            oprList.add(new OperatorDTO(11, "Lasse H Nilesen", "LHN", 2909912191L, "123Abc", 0));
        } catch (OpPasswordException | OpNameException | OpIdException | DALException  ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public OperatorDTO getOperator(int oprId) throws DALException {
        for(int i=0;i<oprList.size();i++) {
            if (oprList.get(i).getOprID()==oprId)
                return oprList.get(i);
        }
        return null;
    }

    @Override
    public List<OperatorDTO> getOperatorList() throws DALException {
        return oprList;
    }

    @Override
    public void createOperatoer(OperatorDTO opr) throws DALException {
        for (OperatorDTO operatoer : oprList) {
            if(opr.getOprID() == operatoer.getOprID())
                throw new DALException("Brugeren eksisterer allerede");
        }
        oprList.add(opr);
    }

    @Override
    public void updateOperatoer(OperatorDTO opr) throws DALException {
        OperatorDTO temp = opr;
        deleteOperatoer(opr);
        createOperatoer(temp);
    }

    @Override
    public void deleteOperatoer(OperatorDTO opr) throws DALException {
        ArrayList<OperatorDTO> tempList = (ArrayList<OperatorDTO>) oprList.clone();
        for(OperatorDTO operatoer : tempList) {
            if(opr.getOprID() == operatoer.getOprID())
                oprList.remove(operatoer);
        }
    }
}