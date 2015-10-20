import java.io.*; //Importacion de librerias

public class AnalizaFile{

//Atributos de la clase//
  String aarchivo;
  String rdline; //lineas leidas
  FileReader fr;
  BufferedReader br;

//Constructor por default: se tuvo que declarar ya que sin el no reconocia el Constructor por default//
  public AnalizaFile(){
    aarchivo = " ";
  }
//Constructor con parametro del nombre del archivo//
  public AnalizaFile(String nombre_archivo){
    aarchivo = nombre_archivo;
  }
//Metodo que obtiene el numero de lineas//
  public int getLines(){
    int numLines = 0;
    try{
      fr = new FileReader(aarchivo);        //se abre el archivo
      br = new BufferedReader(fr);
      while((rdline = br.readLine()) != null){    //lectura de lineas
        numLines++;
      }
    }catch(java.io.IOException ioex){
      return -1;
    }finally{
      try{
        if(null != fr){
          fr.close();       //cierra el archivo
        }
      }catch(java.io.IOException ioex){
      }
    }
    return numLines;
  }
//Metodo que obtiene la primera linea del txt//
  public String getFirstLine(){
    try{
      fr = new FileReader(aarchivo);  //se abre el archivo
      br = new BufferedReader(fr);
      rdline = br.readLine();     //lee una linea
    }catch(java.io.IOException ioex){
      return "ERROR,  especificar un nombre de archivo";
    }finally{
      try{
        if(null != fr){
          fr.close();       //cierre de archivo
        }
      }catch(java.io.IOException ioex){
      }
    }
    return rdline;
  }
//Metodo que obtiene la ultima linea del txt//
  public String getLastLine(){
    String lastLine="";
    try{
      fr = new FileReader(aarchivo);        //abre el archivo
      br = new BufferedReader(fr);
      while((rdline = br.readLine()) != null){      //lee el archivo
        lastLine = rdline;          //lee la ultima linea
      }
    }catch(java.io.IOException ioex){
      return "ERROR,  especificar un nombre de archivo";
    }finally{
      try{
        if(null != fr){
          fr.close();     //se cierra el archivo
        }
      }catch(java.io.IOException ioex){
      }
    }
    return lastLine;
  }

  public String getAllLinesString(){
      String all = "";
      try{
        fr = new FileReader(aarchivo);
        br = new BufferedReader(fr);
        while((rdline = br.readLine()) != null){
          all = all + rdline;
        }
      }catch(java.io.IOException ioex){
      }finally{
        try{
            if(null != fr){
              fr.close();       //cierra el archivo
            }
        }catch(java.io.IOException ioex){
        }
      }
      return all;
  }

  public int[] getAllLinesInt(String regex){

    String allthe = getAllLinesString();
    String [] getall = allthe.split(regex);
    int[] allInt = new int[getall.length];
    for (int i = 0; i < allInt.length ; i++ ) {
      allInt[i] = Integer.parseInt(getall[i]);
    }

    return allInt;
  }

  public void fileWriterInt(String arch_name,int[] arraInt){
      File new_archivo = new File(arch_name);
      try {
        FileWriter fw = new FileWriter(new_archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        for (int cont = 0; cont < arraInt.length ; cont++ ){
          if(cont == 0){
            pw.print(arraInt[cont]);
          }else{
            pw.print(",");
            pw.print(arraInt[cont]);
          }
        }
        pw.close();
        bw.close();
      }catch(IOException e){
        System.out.println("Error al crear el archivo");
      }
    }


//Metodo que sirve como auxiliar para recibir el nombre del txt si se usa el Constructor por defecto//
  public void setFileName(String nfile){
    aarchivo = nfile;
  }

}
