/**
 * <b>IView</b>
 * <p>Interfacet for brugergrænseflade.
 * @author Lasse Holm Nielsen - S123954
 * @version 24-02-2016
 */
public interface IView {
    /**
     * Åbner dialogen i brugergrænsefladen.
     */
    public void dialog();
    
    /**
     * Lukker dialogen i brugergrænsefladen.
     */
    public void exit();
}
