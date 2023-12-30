package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

// link desafio "https://coderbyte.com/api/challenges/json/age-counting"
// conta quantas idades passadas por url são maiores ou iguais a 50
// key = STRING age = NUMBER

class Teste {  
  public static int count(InputStream inputStream) {
      String result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
      String[] resultSplit = result.split(",");
      int qtd = 0;
      for(String resultStringSplit : resultSplit) {
    	  String[] resultStringSplitAge = resultStringSplit.split("=");
    	  try {
    		  int age = 0;
        	  if(resultStringSplitAge[1].contains("[0-9]]+")) {
        		  age = Integer.parseInt(resultStringSplitAge[1]);
        	  } else {
        		  age = Integer.parseInt(resultStringSplitAge[1].split("\"")[0]);
        	  }
        	  if(age >= 50) {
        		  qtd++;
        	  }
    	  } catch(NumberFormatException e) {
    		  
    	  }
      }
      
      return qtd;
  }

  public static void main (String[] args) { 
    System.setProperty("http.agent", "Chrome");
    try { 
      URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
      try {
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        System.out.println(count(inputStream));
      } catch (IOException ioEx) {
        System.out.println(ioEx);
      }
    } catch (MalformedURLException malEx) {
      System.out.println(malEx);
    }
  }
  
}