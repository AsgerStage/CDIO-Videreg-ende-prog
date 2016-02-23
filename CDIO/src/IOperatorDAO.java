import java.util.List;

public interface IOperatorDAO {
	OperatorDTO getOperator(int oprId) throws DALException;
	List<OperatorDTO> getOperatorList() throws DALException;
	void createOperatoer(OperatorDTO opr) throws DALException;
	void updateOperatoer(OperatorDTO opr) throws DALException;
	void deleteOperatoer(OperatorDTO opr) throws DALException;
}
