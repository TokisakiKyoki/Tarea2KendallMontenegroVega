/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author TokisakiKuro
 */
public class VehicleFile {
    
    //atributos
    public RandomAccessFile randomAccessFile;
    private int regsQuantity; //cantidad de registros que tiene mi archivo
    private int regSize; //el tamaño en bytes de mis registros
    private String myFilePath; //ruta del archivo
    
    //constructor
    public VehicleFile(File file) throws IOException{
        //guardar la ruta del archivo
        this.myFilePath = file.getPath();
        
        //tamaño máximo de cada registro del archivo
        this.regSize = 53;
        
        //una validación básica de file
        if (file.exists()&& !file.isFile()) {
            throw new IOException(file.getName() + " is an invaid file");
        }else{
            //crar una nueva instancia de RAF
            randomAccessFile = new RandomAccessFile(file, "rw");
            
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)this.regSize);//Math.ceil redondea hacia arriba
        }
    }//end method
        
    //método para insertar un vehiculo en una posicion especifica
    public boolean putValue(int position,Vehicle vehicleToInsert) throws IOException{
        //vamos a hacer una pequeña validación de position
        if (position >= 0 && position <= this.regsQuantity) {
            
            //verificar que el tamaño sea el adecuado
            if (vehicleToInsert.sizeInBytes() > this.regSize) {
                System.err.println("1002 - record size is too large");
                return false;
            }else{
                //escribir en archivo
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(vehicleToInsert.getName());
                randomAccessFile.writeInt(vehicleToInsert.getYear());
                randomAccessFile.writeFloat(vehicleToInsert.getMileage());
                randomAccessFile.writeBoolean(vehicleToInsert.isAmerican());
                randomAccessFile.writeInt(vehicleToInsert.getSeries());
                
                return true;
            }
            
        }else{
            System.err.println("1001 - position is out of bounds");//numerar error
            return false;
        }
    }//end method
    
    //método para insertar al final del archivo
        public boolean addEndRecord(Vehicle vehicle) throws IOException{
            boolean success = putValue(this.regsQuantity, vehicle);
            
            if (success) {
                ++this.regsQuantity;
            }
            return success;
        }//end method
        
        //obtener un vehiculo de una posición específica
        public Vehicle getVehicle(int position) throws IOException{
            //validar position
            if (position >= 0 && position <= this.regsQuantity) {
                //colocamos el brazo en el lugar adecuado
                randomAccessFile.seek(position * this.regSize);
                //leer
                Vehicle vehicleTemp = new Vehicle();
                vehicleTemp.setName(randomAccessFile.readUTF());
                vehicleTemp.setYear(randomAccessFile.readInt());
                vehicleTemp.setMileage(randomAccessFile.readFloat());
                vehicleTemp.setAmerican(randomAccessFile.readBoolean());
                vehicleTemp.setSeries(randomAccessFile.readInt());
                
                if (vehicleTemp.getSeries()==(-1)) {
                    return null;
                }else{
                    return vehicleTemp;
                }
            }else{
                System.err.println("1003 - position is out of bounds");
                return null;
            }
        }//end method
    
        //método para retornar todos los vehiculos que estén dentro del archivo
        public ArrayList<Vehicle> getVehicleList() throws IOException{
            //crear un instancia de un array list
            ArrayList<Vehicle> arrayListOfVehicles = new ArrayList<>();
            
            //recorrer el arreglo para insertar en la lista
            for (int i = 0; i < this.regsQuantity; i++) {
                Vehicle vehicleTemp = this.getVehicle(i);
                
                //insertar ese vehiculo en la lista
                if (vehicleTemp != null) {
                    arrayListOfVehicles.add(vehicleTemp);
                }
            }
            return arrayListOfVehicles;
        }//end method
        
        public boolean deleteRecord(int series) throws IOException{
            Vehicle vehicleTemp = this.getVehicle(0);
            
            for (int i = 0; i <+ this.regsQuantity; i++) {
                vehicleTemp = this.getVehicle(i);
                
                if (vehicleTemp.getSeries()==(series)) {
                    vehicleTemp.setSeries(-1);
                    return this.putValue(i, vehicleTemp);
                }
            }
            return false;
        }//end method
        
        public boolean editVehicle(int series, String name, int year, float mileage, boolean american) throws IOException{
            Vehicle vehicleTemp = this.getVehicle(0);
            
            for (int i = 0; i <+ this.regsQuantity; i++) {
                vehicleTemp = this.getVehicle(i);
                if (vehicleTemp.getSeries()==(series)) {
                    vehicleTemp.setName(name);
                    vehicleTemp.setYear(year);
                    vehicleTemp.setMileage(mileage);
                    vehicleTemp.setAmerican(american);
                    vehicleTemp.setSeries(series);
                    return this.putValue(i, vehicleTemp);
                
            }
            return false;
        }return false;
    }
        
        public Vehicle buscar(int series) throws IOException{
        Vehicle vehicleTemp = this.getVehicle(0);
            
            for (int i = 0; i <+ this.regsQuantity; i++) {
                vehicleTemp = this.getVehicle(i);
                
                if (vehicleTemp.getSeries()==(series)) {
                    vehicleTemp.getName();
                    vehicleTemp.getYear();
                    vehicleTemp.getMileage();
                    vehicleTemp.isAmerican();
                    return vehicleTemp;
                }
            }return vehicleTemp;
            
        }//end method

        
}
