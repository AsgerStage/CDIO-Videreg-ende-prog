package cdio.data;
import cdio.exceptions.DALException;
import cdio.exceptions.OpIdException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;
import cdio.models.OperatorDTO;
import java.util.ArrayList;
import java.util.List;

public class OperatorDAO implements IOperatorDAO 
{
    ArrayList<OperatorDTO> Oplist = new ArrayList<>();

    public OperatorDAO() {
        try {
            Oplist.add(new OperatorDTO(99, "Admin", "ADM", 0000000000L, "Abc0234", 1));
            Oplist.add(new OperatorDTO(11, "Lasse H Nilesen", "LHN", 2909912191L, "123Abc", 0));
        } catch (OpPasswordException | OpNameException | OpIdException | DALException  ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public OperatorDTO getOperator(int oprId) throws DALException {
        for(int i=0;i<Oplist.size();i++) {
            if (Oplist.get(i).getOprID()==oprId)
                return Oplist.get(i);
        }
        return null;
    }

    @Override
    public List<OperatorDTO> getOperatorList() throws DALException {
        return Oplist;
    }

    @Override
    public void createOperatoer(OperatorDTO opr) throws DALException {
        for (OperatorDTO operatoer : Oplist) {
            if(opr.getOprID() == operatoer.getOprID())
                throw new DALException("Brugeren eksisterer allerede");
        }
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
        for(OperatorDTO operatoer : tempList) {
            if(opr.getOprID() == operatoer.getOprID())
                Oplist.remove(operatoer);
        }
    }
}