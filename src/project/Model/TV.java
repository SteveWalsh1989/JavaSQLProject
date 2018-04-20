package project.Model;

/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 12/4/18
 *
 *****************************/



// Tv is a subclass of Product class
public class TV extends Product {


    //----------------------------//
    //      Attributes            //
    //----------------------------//

   private String make;                 // hold make of the tv
   private String type;                 // hold type of tv
   private int screenSize;              // hold screen size of tv
   private boolean capableOf3D = false; // informs if tv is capable of displaying in 3D


    //----------------------------//
    //      Constructor           //
    //----------------------------//

    /**
     * default constructor
     */
    public TV(){
    }
    /**
    *  Overloaded Constructor
    */
    public TV(double iPrice, String iMake,
              String iType, int iScreenSize, boolean iCapableof3D){

        // set super class attributes
        super.setName(iMake);
        super.setDescription(iType);
        super.setPrice(iPrice);

        // set local attributes
        make        = iMake;
        type        = iType;
        screenSize  = iScreenSize;
        capableOf3D = iCapableof3D;


    }

    //----------------------------//
    //      Methods               //
    //----------------------------//
    //
    // Set methods
    //
    /**
     * setMake
     *
     * set the make of the tv in superclass as name
     *
     * @param iMake - make of tv
     */
    public void setMake(String iMake){

        super.setName(iMake);
    }
    /**
     * setType
     *
     * set the type of the tv in super class as description
     *
     * @param iType - type of tv
     */
    public void setType(int iType){

        switch (iType) {                                        // select add method based on user choice

            case 1:                                             // Scenario 1 : choice is LED

                this.type = "LED" ;                             // sets type to LED
                break;
            case 2:                                             // Scenario 2 : choice is LCD

                this.type = "LCD" ;                             // sets type to LCD
                break;
            case 3:                                             // Scenario 3 : choice is Plasma

                this.type = "Plasma" ;                          // sets type to Plasma
                break;
        }
        super.setDescription(this.type) ;                       //sets the type to the super description
    }
    /**
     * setType
     *
     * set the type of the tv in super class as description
     *
     * @param iType - type of tv
     */
    public void setType(String iType){

                this.type = iType ;                             // sets type

        super.setDescription(this.type) ;                       //sets the type to the super description
    }
    /**
     * setType
     *
     * set the type of the tv in super class as description
     *
     * @param iType - type of tv
     */
    public int findType(String iType){

        int choice = 0;

        switch (iType) {
            case "LED":

                choice = 1;

                break;
            case "LCD":

                choice = 2;

                break;
            case "Plasma":


                choice = 3;
                break;
        }
        return choice;
    }
    /**
     * setScreenSize
     *
     * set the screensize of the tv
     *
     * @param iScreenSize - screensize of tv
     */
    public void setScreenSize(int iScreenSize){
        this.screenSize = iScreenSize;
    }
    /**
     * convertBoolean
     *
     * converts string to boolean value
     *
     * @param value - value read in from file
     */
    public boolean convertBoolean(String value){

        boolean isValid = false;

        if ( value.equals("true")) {
            isValid = true;
        }
        else if ( value.equals("false")){

            isValid = false;
        }
        return isValid;
    }
    /**
     * set3DCapability
     *
     * set the capability of the tv to display 3D content
     *
     * @param i3DCapability - if the tv has 3D Capability
     */
    public void set3DCapability(boolean i3DCapability) {
        this.capableOf3D = i3DCapability;
    }

    //
    // Get methods
    //
    /**
     * getMake
     *
     * get the make of the tv
     *
     * @return make - returns make of the tv
     */
    public String getMake() {
        return make;
    }
    /**
     * getType
     *
     * get the type of the tv
     *
     * @return type - returns type of the tv
     */
    public String getType(){
        return type;
    }
    /**
     * getScreenSize
     *
     * get the screensize of the tv
     *
     * @return screenSize - returns screensize of the tv
     */
    public int getScreenSize() {
        return screenSize;
    }
    /**
     * get3DCapability
     *
     * find out if the tv is 3D Capable
     *
     * @return capableOf3D - returns if the tv is 3D Capable
     */
    public boolean get3DCapability(){
        return capableOf3D;
    }

    /**
     * print
     *
     * Prints details of the tv by calling the overloaded super print() method
     *
     *
     */
    public void print() {

        super.print(this.screenSize, this.capableOf3D);         // call print from super class to get
    }
}
