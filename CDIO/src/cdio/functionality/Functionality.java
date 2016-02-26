package cdio.functionality;
import cdio.data.IOperatorDAO;
import cdio.exceptions.DALException;
import cdio.models.OperatorDTO;
import java.util.Random;

public class Functionality implements IFunctionality
{
    private final IOperatorDAO dao;

    public Functionality(IOperatorDAO dao) {
        this.dao = dao;
    }

    @Override
    public int createOpr(String oprNavn, String ini, long cpr, int rank) {
        Random random = new Random();
        
        int oprID = generateID();

        StringBuilder pass = new StringBuilder();
        for(int i = 0; i < 20; i++) {
            pass.append((char) (random.nextInt(122 - 33) + 33));
        }

        OperatorDTO opr = new OperatorDTO(oprID, oprNavn, ini, cpr, pass.toString(), rank);
        try {
            dao.createOperatoer(opr);
            return oprID;
        } 
        catch (DALException ex) {
            return -1;
        }
    }

    @Override
    public boolean deleteOpr (int oprID) {
        try {
            dao.deleteOperatoer(dao.getOperator(oprID));
            return true;
        }
        catch (DALException ex) {
            return false;
        }
    }

    @Override
    public boolean updateOpr(int oprID, String name, long cpr, int rank) {
        try {
            OperatorDTO opr = dao.getOperator(oprID);
            
            if(name != null)
                opr.setName(name);
            if(cpr != -1)
                opr.setCpr(cpr);
            if(rank != -1)
                opr.setRank(rank);
            
            dao.updateOperatoer(opr);
            return true;
        } 
        catch (DALException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changePass(int oprID, String oldPassword, String newPassowrd1, String newPassword2) {
        OperatorDTO opr;
        try {
            opr = dao.getOperator(oprID);

            if(newPassowrd1.equals(newPassword2) && opr != null) {
                if(opr.getPassword().equals(oldPassword)) {
                    opr.setPassword(newPassowrd1);
                    return true;
                }
            }
        } 
        catch (DALException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public double measure(double tara, double brutto) {
        return brutto - tara;
    }

    @Override
    public boolean login(int userId, String password) {
        try {
            OperatorDTO opr = dao.getOperator(userId);
            if(opr != null)
                return opr.getPassword().equals(password);
        } 
        catch (DALException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public OperatorDTO readOpr(int oprID) {
        try {
            return dao.getOperator(oprID);
        } 
        catch (DALException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int generateID() {
        Random random = new Random ();

        int oprID = 11 + random.nextInt(89);

        try {
            if(dao.getOperator(oprID) == null) {
                return oprID;
            }
            else
                return generateID();
        } 
        catch (DALException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}