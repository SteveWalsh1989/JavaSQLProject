package project.Tests;

import project.Database.DB_Display;

import static org.junit.Assert.assertEquals;

/**
 * Tests connectivity to database
 */
public class ConnectDBTest {



    /**
     * Tests connectivity to database
     *
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testConnectDB() throws Exception {


        String successfulConnect = "Connected Successfully";


        String connection  = DB_Display.connectDB();


        assertEquals(connection,successfulConnect);

    }








}