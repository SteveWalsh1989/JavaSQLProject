package sample.Model;


/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 12/4/18
 *
 *****************************/


//---------------//
//    Class      //
//---------------//
public abstract class Product {

    //----------------------------//
    //      Attributes            //
    //----------------------------//

    private String name;
    private String description;
    private double price;
    public static int count = 0;        // keep track of number of products and used to create unique product ID
    private int productID = 1;

    //----------------------------//
    //      Constructor           //
    //----------------------------//
    /**
     * Default Constructor
     */
    public Product(){

        //create product id from the count which is incremented
        productID = ++count;

    }
    //----------------------------//
    //      Methods               //
    //----------------------------//
    //
    // Set methods
    //
    /**
     * setName
     *
     * set the name of the product
     *
     * @param name - name of product
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * setDescription
     *
     * set the description of the product
     *
     * @param description - name of product
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     * setPrice
     *
     * set the name of the product
     *
     * @param price - price of product
     */
    public void setPrice(Double price){
        this.price = price;
    }

    /**
     * setProductID
     *
     * set the product ID of the product
     *
     * @param ProductID - productID of product
     */
    public void setProductID(int ProductID){
        this.productID = ProductID;
    }
    //
    // Get methods
    //
    /**
     * getName
     *
     * get the name of the product
     *
     * @return name - returns name of the product
     */
    public String getName(){
        return this.name;
    }

    /**
     * getDescription
     *
     * get the description of the product
     *
     * @return description - returns description of the product
     */
    public String getDescription(){
        return this.description;
    }
    /**
     * getPrice
     *
     * get the price of the product
     *
     * @return price - returns price of the product
     */
    public Double getPrice(){
        return this.price;
    }
    /**
     * getProductID
     *
     * get the product ID of the product
     *
     * @return productID - returns product ID of the product
     */
    public int getProductID(){
        return this.productID;
    }
    /**
     * prints
     *
     * prints details of the product
     *
     */
    public void print() {

        System.out.println("Product ID : "                + this.productID   + "\n" +
                           "Name of the product: "        + this.name        + "\n" +
                           "Description of the product: " + this.description + "\n" +
                           "Price of product: "           + this.price);
    }



    /**
     * prints TV details
     *
     *
     * Overloaded print method
     *
     * prints details of the TV product
     *
     */
    public void print(int screenSize, Boolean is3DCompatible)  {


        System.out.println("Product ID: "       + this.productID    + "\n" +
                           "Make of the TV: "   + this.name         +  "\n" +
                           "Type of the TV: "   + this.description +  "\n" +
                           "Screen size TV: "   + screenSize       +  "\n" +
                           "3D capability:  "   + is3DCompatible   +  "\n" +
                           "Price of TV: "      + this.price);
    }

    /**
     * prints Phone details
     *
     *
     * Overloaded print method
     *
     * prints details of the Phone product
     *
     */
    public void print(String storage, String model)  {

            System.out.println("Product ID : "   + this.productID    + "\n" +
                        "Make of Phone: "        + this.name         +  "\n" +
                        "Model of Phone: "       + this.description  +  "\n" +
                        "Storage Capacity: "     + storage           +  "\n" +
                        "Price of Phone: "       + this.price);

    }




} // close class
