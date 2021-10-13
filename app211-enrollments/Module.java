
/**
 * Write a description of class Module here.
 *
 * @author (Lottie Scragg)
 * @version (13/10/2021)
 */
public class Module
{
    // instance variables
    private String code;
    private String title;
    private int credit;

    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        credit = 0;
    }

    /**
     * Return code
     */
    public String getCode()
    {
        return code;
    }
    /**
     * Return title
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * Return credit
     */
    public int getCredit()
    {
        return credit;
    }
    /**
     * Set credit
     */
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    /**
     * 
     */
    public void print()
    {
        System.out.println("Module code: " + code + ": " + title);
        System.out.println("Module credit: " + credit);
        System.out.println();
    }
}
