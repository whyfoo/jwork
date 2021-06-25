package haidarhanif.jwork.enumerated;
/**
 * Enumeration class JobCategory
 *
 * @author Haidar Hanif
 * @version 25-03-2021
 */
public enum JobCategory
{
    WebDeveloper("Web Developer"),
    FrontEnd("Front End"),
    BackEnd("Back End"),
    UI("User Interface"),
    UX("User Experience"),
    Devops("Devops"),
    DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");
    
    private String category;
    
    JobCategory(String category) {
        this.category = category;
    }
    
    public String toString(){
        return category;
    }
}