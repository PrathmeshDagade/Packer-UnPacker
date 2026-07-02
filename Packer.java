import java.util.*;
import java.io.*;


class PackingActivity 
{

    String Dirname ; 
    String PackingFileName ;
    int iRet = 0 , i = 0 , j = 0  ; 


    PackingActivity(String A , String B ) 
    {
       this.Dirname = A ;
       this.PackingFileName = B ;
    }

    public void PackDir()
    {
        try 
        {
            // dir object 
            File Dirobj = new File(Dirname) ;

            // check wether dir is exist and isdir 
            if((Dirobj.exists()) && (Dirobj.isDirectory()) )
            {
                // object of packer file
                File Packobj = new File(PackingFileName) ;
               boolean bret = Packobj.createNewFile() ;

                if(bret == false )
                {
                    System.out.println("ERROR : Cant Create Packer File "+PackingFileName);
                    return ;
                }

                System.out.println("Packer File Created Sucessfully ");

                // stores File Name and Size 
                String Header = null ;

                // File Array to Store file names drom directory 
                File Arr[] = Dirobj.listFiles() ; 
                
                // Bytes Buffer to write inside packed file 
                byte[] Buffer = new byte[1024] ;

                // Object to write into file 
                FileOutputStream Filewriter = new FileOutputStream(Packobj) ;
                
                // Travel Each File Now 
                for( i = 0 ;  i < Arr.length ; i++ )
                {
                    // holds filename and its size   
                    Header = Arr[i].getName()+" "+Arr[i].length() ;

                    // make header of 100 bytes of length 
                    for( j = Header.length() ; j < 100 ; j++ )
                    {
                        Header = Header + " " ;
                    }

                    // object to read from file 
                    FileInputStream Filereader = new FileInputStream(Arr[i]) ;


                    // Write Header into File ; 
                    Filewriter.write(Header.getBytes()) ;


                    // read the data of file
                    while(( iRet = Filereader.read(Buffer)) != -1 )
                    {
                        // write readed bytes in packed file 
                        Filewriter.write(Buffer,0 ,iRet) ; 
                    }

                    // close current file we packed 
                    Filereader.close();


                }

                Filewriter.close() ;

            }
            else 
            {
               System.out.println("ERROR : there is no such directory present"+Dirname);
               return ; 
            }

        }
        catch(IOException EOBJ)
        {

        }

    }

}

public class Packer
{
    public static void main (String A [] )
    {
        String DirectoryName = null ;
        String PackerName = null ;

        try 
        {
            BufferedReader bobj = new BufferedReader( new InputStreamReader(System.in)) ;

            System.out.println("Enter Directory Name to pack a file ") ;
            DirectoryName = bobj.readLine() ;

            System.out.println("Enter PackerFIle name to pack the files") ;
            PackerName = bobj.readLine() ;

        }
        catch (IOException ioeobj)
        {

        }
       

        PackingActivity Packingobj = new PackingActivity(DirectoryName,PackerName) ;

        Packingobj.PackDir();
    }
    
}
