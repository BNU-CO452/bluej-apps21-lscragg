
/**
 * Write a description of class Module here.
 *
 * @author (Lottie Scragg)
 * @version (9/10/2021)
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
        return this.code;
    }
    /**
     * Return title
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     * Return credit
     */
    public int getCredit()
    {
        return this.credit;
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
        System.out.println("Course code: " + code + ": " + title);
        System.out.println("Course credit: " + credit);
        System.out.println();
    }
}
