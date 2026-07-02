import java.util.*;
import java.io.*;
import java.nio.file.Files;

class UnPackingActivity 
{
    String PackerName ; 
    int iRet = 0 ;
    
    UnPackingActivity(String A )
    {
        this.PackerName = A ;
    }

    public void UnPack()
    {
        try 
        {
            // object of packed file 
            File packdobj =  new File(PackerName) ;
            
            // check if packed file exist or not 
            if ((packdobj.exists()) && (packdobj.isFile()))
            {
                // read obj from packed file 
                FileInputStream packereader = new FileInputStream(packdobj) ;

                // byte buffer to read 100 bytes 
                byte HeaderBuffer [] = new byte [100] ;

                // string header to conver byte to string 
                String Header = null ;
                
                // loop to read 100 bytes in header buffer  
                while ((iRet = packereader.read(HeaderBuffer,0,100))  != -1 )
                {

                    // convert bytes into header string 
                    Header = new String(HeaderBuffer) ;   
            
                    // remove extra spaces from buffer 
                    Header = Header.trim() ;
            
                    // tokeniaze them using " "
                    String token[] = Header.split(" ") ;

                    // create newfile 
                    File newfile = new File(token[0]) ;


                    boolean bret = newfile.createNewFile() ; 

                    if(bret == false )
                    {
                        System.out.println("ERROR : Cant Create Packer File "+token[0]);
                        return ;
                    }

                    // take filesize 
                    int FileSize = Integer.parseInt(token[1]) ;

                    // obj to write into newfile 
                    FileOutputStream filewriter = new FileOutputStream(newfile) ;

                    // buffer to read the file data 
                    byte Buffer [] = new byte[FileSize] ;

                    // read file data of filesize from packereader
                    packereader.read(Buffer,0,FileSize) ;

                    // write into newfile 
                    filewriter.write(Buffer,0,FileSize) ;

                    // close filewriter
                    filewriter.close(); 

                }

                packereader.close() ;

            }
            else 
            {
                System.out.println("ERROR : No Such File to Unpack"+PackerName);
                return ;
            }


        }
        catch(IOException eobj )
        {

        }

    }


}




public class Unpacker 
{
    public static void main ( String A [] )
    {

        Scanner sobj = new Scanner(System.in) ;
        String PackedFileName = null ;


        System.out.println(" enter packed file name to unpack");
        PackedFileName = sobj.nextLine() ;


        UnPackingActivity unpackerobj = new UnPackingActivity(PackedFileName) ;

        unpackerobj.UnPack();
    }    
}
