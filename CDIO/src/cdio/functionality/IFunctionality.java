package cdio.functionality;
import cdio.models.OperatorDTO;

public interface IFunctionality 
{
    /**
     * <b>Opret operatør</b>
     * <p>Opretter en ny operatør ud fra de givne data.
     * @param oprNavn
     *      Operatørens navn. Skal være mindst to karaktere lang
     * @param ini
     *      Operatørens initialer
     * @param cpr
     *      Operatørens CPR-nummer.
     * @param rank
     *      Operatørens rank (rettigheder). 1 = administrator, 0 = operatør og -1 = ingen adgang.
     * @return 
     *      Returnerer den nye operatørs ID. Returnerer -1 hvis handlingen mislykkes.
     */
    public int createOpr(String oprNavn, String ini, long cpr, int rank);

    /**
     * <b>Slet operatør</b>
     * <p>Sletter operatøren med det angivne ID.
     * @param oprID
     *      Operatør ID for den operatør som skal slettes.
     * @return 
     *      Returnerer true hvis handlingen lykkes.
     */
    public boolean deleteOpr(int oprID);

    /**
     * <b>Opdater operatør</b>
     * <p>Opdaterer en operatørs data. Opdaterer ikke felter der angives med en null værdi.
     * @param oprID
     *      Operatørens ID
     * @param name
     *      Operatørens navn. Set null hvis feltet ikke skal opdateres.
     * @param cpr
     *      Operatørens CPR-nummer. set -1 hvis feltet ikke skal opdateres.
     * @param rank
     *      Operatørens rank/tilladelser. set -1 hvis feltet ikke skal opdateres.
     * @return 
     *      Returner true hvis operatøren blev opdateret.
     */
    public boolean updateOpr(int oprID, String name, long cpr, int rank);

    /**
     * <b>Læs operatør</b>
     * <p>Henter en operatørs data ud fra det angivne operatør ID.
     * @param oprID
     *      Operatørens ID.
     * @return 
     *      Operatør objekt som matcher operatør ID'et. Returnerer null hvis operatøren ikke kunne findes.
     */
    public OperatorDTO readOpr(int oprID);

    /**
     * <b>Skift password</b>
     * <p>Skifter en operatørs password.
     * @param oprID
     *      Operatørens ID.
     * @param oldPass
     *      Det gamle password.
     * @param newPass1
     *      Det nye password.
     * @param newPass2
     *      Gentagelse af det nye password.
     * @return 
     *      returnerer sandt hvis passwordet blev ændret.
     */
    public boolean changePass(int oprID, String oldPass, String newPass1, String newPass2);

    /**
     * <b>Afvejning</b>
     * <p>Måler nettovægten for en pakke.
     * @param tara
     *      Pakkens tara vægt.
     * @param brutto
     *      Pakkens bruttovægt.
     * @return 
     *      Pakkens nettovægt.
     */
    public double measure(double tara, double brutto);

    /**
     * <b>Login</b>
     * <p>Undersøger om det angivne operatør ID matcher passwordet.
     * @param oprID
     *      Operatørens ID.
     * @param password
     *      Operatørens password.
     * @return 
     *      Returnerer true hvis operatør ID og passwordet matcher.
     */
    public boolean login(int oprID, String password);
}