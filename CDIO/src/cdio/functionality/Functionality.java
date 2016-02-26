package cdio.functionality;
import cdio.data.IOperatorDAO;
import cdio.exceptions.DALException;
import cdio.exceptions.OpIdException;
import cdio.exceptions.OpNameException;
import cdio.exceptions.OpPasswordException;
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
        int oprID = generateID();
        String pass = generatePassword();

        try {
            OperatorDTO opr = new OperatorDTO(oprID, oprNavn, ini, cpr, pass, rank);
            dao.createOperatoer(opr);
            return oprID;
        } 
        catch (DALException | OpPasswordException | OpNameException | OpIdException ex) {
            return -1;
        }
    }

    @Override
    public boolean deleteOpr (int oprID) {
        try {
            dao.deleteOperatoer(dao.getOperator(oprID));
            return true;
        }
        catch (DALException | NullPointerException ex) {
            return false;
        }
    }

    @Override
    public boolean updateOpr(int oprID, String name, long cpr, int rank) throws OpNameException {
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
        catch (DALException ex) { }
        catch (OpNameException ex) {
            throw ex;
        }
        return false;
    }

    @Override
    public boolean changePass(int oprID, String oldPassword, String newPassword1, String newPassword2) throws OpPasswordException {
        OperatorDTO opr;
        try {
            opr = dao.getOperator(oprID);

            if(newPassword1.equals(newPassword2) && opr != null) {
                if(opr.getPassword().equals(oldPassword)) {
                    opr.setPassword(newPassword1);
                    return true;
                }
            }
        } 
        catch (DALException ex) {
            return false;
        }
        catch (OpPasswordException ex) {
            throw ex;
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
    
    private String generatePassword() {
        Random random = new Random();
        Character[] chars = new Character[69];
        
        chars[0] = (char) 33;
        chars[1] = (char) 43;
        chars[2] = (char) 45;
        chars[3] = (char) 46;
        chars[4] = (char) 61;
        chars[5] = (char) 63;
        chars[6] = (char) 95;
        
        int c = 0;
        for (int i = 7; c < 17; i++) {
            chars[i] = Character.forDigit(c, 10);
            c++;
        }
        
        c = 65;
        for (int i = 17; i < 43; i++) {
            chars[i] = (char) c;
            c++;
        }
        
        c = 97;
        for (int i = 43; i < 69; i++) {
            chars[i] = (char) c;
            c++;
        }
        
        StringBuilder pass = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            pass.append(chars[random.nextInt(68)]);
        }
        pass.append(chars[random.nextInt(6)]);
        pass.append(chars[random.nextInt(17) + 7]);
        pass.append(chars[random.nextInt(43) + 18]);
        
        return pass.toString();
    }
}