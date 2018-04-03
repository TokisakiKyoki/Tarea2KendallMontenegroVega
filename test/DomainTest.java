/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TokisakiKuro
 */
public class DomainTest {
    
    public DomainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void hello() {
        Vehicle v1 = new Vehicle("Toyota", 2005, 200, true, 5288392);
        System.out.println(v1.toString());
        System.out.println(v1.sizeInBytes());
    }
    
    //@Test
    public void insertVehicle() throws IOException{
        File file = new File("./vehicle.dat");
        VehicleFile vehicleFile = new VehicleFile(file);
        
        //vehiculos a insertar
        Vehicle v1 = new Vehicle("Toyota", 2005, 200, true, 5288392);
        Vehicle v2 = new Vehicle("Honda", 2008, 4000, false, 1284023);
        Vehicle v3 = new Vehicle("Nissan", 2001, 100, true, 8372640);
        
        vehicleFile.addEndRecord(v1);
        vehicleFile.addEndRecord(v2);
        vehicleFile.addEndRecord(v3);
    }
    
    //@Test
    public void readVehicle() throws IOException{
        File file = new File("./vehicle.dat");
        VehicleFile vehicleFile = new VehicleFile(file);
        
        Vehicle vehicleTemp = vehicleFile.getVehicle(2);
        System.out.println(vehicleTemp.toString());
        
    }
    
    //@Test
    public void deleteVehicle() throws IOException{
        File file = new File("./vehicle.dat");
        VehicleFile vehicleFile = new VehicleFile(file);
        
        boolean vehicleTemp = vehicleFile.deleteRecord(8372640);
    }
    
    //@Test
    public void editVehicle() throws IOException{
        File file = new File("./vehicle.dat");
        VehicleFile vehicleFile = new VehicleFile(file);
        
        boolean vehicleTemp = vehicleFile.editVehicle(8372640, "Suzuki", 2017, 600, true);
    }
    
    @Test
    public void readAllVehicle() throws IOException{
        File file = new File("./vehicle.dat");
        VehicleFile vehicleFile = new VehicleFile(file);
        
        ArrayList<Vehicle> myArrayList = vehicleFile.getVehicleList();
        String a = "";
    }
    
}
