package badass.calendar;

import java.util.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.spec.PBEKeySpec;

import javax.crypto.*;

/**
 * Manages the accounts of the program.
 * 
 * @author Jason Paximadas
 */
public class Account
{
    private static ArrayList<String> firstNames = new ArrayList<>();
    private static ArrayList<String> lastNames = new ArrayList<>();
    private static ArrayList<byte[]> hashes= new ArrayList<>();
    private static ArrayList<byte[]> salts= new ArrayList<>();
    private static ArrayList<Integer> iterations = new ArrayList<>();
    private static int desiredIterations = 2000;
    private static int curUser = -1;
    
    private static final File file = new File("accounts.ser");
    
    /**
     * Saves the account data to a file.
     * Postcondition: Data is saved as an array of arraylists.
     * @throws java.io.FileNotFoundException
     */
    public static void saveAccounts() throws FileNotFoundException,IOException{
        ArrayList[] archive = new ArrayList[5];
        archive[0] = firstNames;
        archive[1] = lastNames;
        archive[2] = hashes;
        archive[3] = salts;
        archive[4] = iterations;
        
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(archive);
        
        oos.close();
        fout.close();
    }
    /**
     * Loads the account data into memory.
     * Postcondition: A file that holds account data exists.
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void loadAccounts()throws FileNotFoundException,IOException,ClassNotFoundException{
        try{
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fin);
            ArrayList[] archive = (ArrayList[]) ois.readObject();
            
            firstNames = (ArrayList<String>)archive[0];
            lastNames = (ArrayList<String>)archive[1];
            hashes = (ArrayList<byte[]>)archive[2];
            salts = (ArrayList<byte[]>)archive[3];
            iterations = (ArrayList<Integer>)archive[4];
            
            ois.close();
            fin.close();
        }catch(FileNotFoundException e){
            saveAccounts();
        }
    }
    /**
     * Removes an account from the data structure.
     * @param lastName the last name of the user
     * @param password the password of the user
     * @return true if the account was removed, false if not
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     */
    public static boolean removeAccount(String lastName, String password)throws NoSuchAlgorithmException, InvalidKeySpecException{
        if(!validate(lastName,password)) return false;
        int index = lastNames.indexOf(lastName);
        if(index<0) return true;
        lastNames.remove(index);
        firstNames.remove(index);
        hashes.remove(index);
        salts.remove(index);
        iterations.remove(index);
        if(curUser == index) curUser = -1;
        return true;
    }
    /**
     * Creates a new account in the data structure.
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param password the password of the user\
     * @return true if the account was created, false if not
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     */
    public static boolean newAccount(String firstName, String lastName, String password)throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        //generate salt
        if(!(lastNames.indexOf(lastName)<0)) return false;
        byte[] salt = new byte[16];
        
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
       
        sr.nextBytes(salt);
        
        //make a char array password
        char[] passwordArr= password.toCharArray();
        
        //PBKDF2WithHmacSHA1
        byte[] digested = digest(passwordArr,salt,desiredIterations);
              
        //store the information in memory
        firstNames.add(firstName);
        lastNames.add(lastName);
        hashes.add(digested);
        salts.add(salt);
        iterations.add(desiredIterations);
        return true;
        //saveAccounts();
        //System.out.println("Made entry with hash: " + toHex(digested) + " and salt: " + toHex(salt));
    }
    /**
     * Sets the number of iterations of PBKDF2withHmacSHA1 to perform
     * @param number of iterations
     * Postcondition: desiredIterations>=1000
     */
    static void setIterations(int i){
        if(desiredIterations>=1000)desiredIterations=i;
    }
    /**
     * Performs PBKDF2withHmacSHA1 on an inputer and a salt iter times
     * @param input the input
     * @param salt the salt
     * @param iter the number of iterations
     * @return the result of the stretched and salted hash
     */
    private static byte[] digest(char[] input, byte[] salt, int iter) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        PBEKeySpec spec = new PBEKeySpec(input, salt, iter, 64 * 8); //specify how the stretched hash should be ocontructed
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");//specify the maker
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return hash;
    } 
    /**
     * Validates a password.
     * @param lastName the last name of the user
     * @param password the user's password
     * @return true if the password is correct, false if it isn't
     * Postcondition: the number of iterations on the stretched hash will be correct
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     */
    public static boolean validate(String lastName, String password)throws NoSuchAlgorithmException, InvalidKeySpecException{
        //find the user
        int index = -1;
        for(int i=0; i<lastNames.size(); i++)
            if(lastNames.get(i).equals(lastName))
                index = i;
        
        if(index==-1) return false; //if the user doesn't exist, deny the login
        
        byte[] userSalt = salts.get(index); //get the salt
        int databaseiterations = iterations.get(index); //find the iterations of the password
        
        byte[] userHash = digest(password.toCharArray(), userSalt, databaseiterations); //find the hash
        byte[] databasehash = hashes.get(index); //get the correct hash
                
        //check hash for differences
        for(int i = 0; i<userHash.length;i++){
            if(databasehash[i] != userHash[i]) return false;
        }
        
        //if the number of iterations isn't correct, rehash, correct iteration number, and store the data
        if(databaseiterations!=desiredIterations){
            hashes.set(index,digest(password.toCharArray(),userSalt, desiredIterations));
            iterations.set(index,desiredIterations);
            System.out.println("iterations changed to " + desiredIterations);
        }
        
        curUser = index; //define the current user
        return true;
    }
    /**
     * Gets the name of the current user.
     * @return the name of the current user
     */
    public static String getCurrentUser(){
        return getUsername(curUser);
    }
    /**
     * Gets the username at an index in the data structure.
     * @param i the index
     * @return the full name of the person
     */
    private static String getUsername(int i){
        if(i<0) return "no user";
        else
        return firstNames.get(i) + " " + lastNames.get(i);
    }
    /**
     * Lists all the users in the database.
     * @return String listing all Users, separated by "|"
     */
    public static String allUsers(){
        int users = lastNames.size();
        String list = "";
        for(int i=0;i<users;i++){
            //System.out.println("checking " + i);
            list += getUsername(i) + "|";
        }    
        return list;
    }
    
}
