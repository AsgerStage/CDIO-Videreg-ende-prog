package cdio.data;
import cdio.exceptions.DALException;

import java.util.List;

public interface IOperatorDAO 
{
    /**
     * <b>Hent operatør</b>
     * <p>Henter en operatør ud fra et givet operatør ID.
     * @param oprId
     *      Operatør ID.
     * @return
     *      Det operatør ID som matcher ID'et. Returnerer null hvis operatøren ikke blev fundet.
     * @throws DALException 
     *      Smider en Data Access Layer exception hvis der opstår en fejl under handlingen.
     */
    public OperatorDTO getOperator(int oprId) throws DALException;
    
    /**
     * <b>Hent operatørliste</b>
     * <p>Henter listen af alle registrerede operatøre.
     * @return
     *      En liste med alle operatøre som DTO objekter.
     * @throws DALException 
     *      Smider en Data Access Layer exception hvis der opstår en fejl under handlingen.
     */
    public List<OperatorDTO> getOperatorList() throws DALException;
    
    /**
     * <b>Opret operatør</b>
     * <p>Tilføjer den givne operatør til operatørlisten.
     * @param opr
     *      Operatør DTO'et som skal tilføjes.
     * @throws DALException 
     *      Smider en Data Access Layer exception hvis der opstår en fejl under handlingen.
     */
    public void createOperatoer(OperatorDTO opr) throws DALException;
    
    /**
     * <b>Opdater operatør</b>
     * <p>Opdaterer en operatør i operatørlisten.
     * @param opr
     *      Operatør DTO'et som skal opdateres.
     * @throws DALException 
     *      Smider en Data Access Layer exception hvis der opstår en fejl under handlingen.
     */
    public void updateOperatoer(OperatorDTO opr) throws DALException;
    
    /**
     * <b>Slet operatør</b>
     * <p>Sletter en operatør i operatørlisten.
     * @param opr
     *      Operatør DTO'et som skal slettes.
     * @throws DALException 
     *      Smider en Data Access Layer exception hvis der opstår en fejl under handlingen.
     */
    public void deleteOperatoer(OperatorDTO opr) throws DALException;
}
