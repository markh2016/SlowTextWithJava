/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlowPrinting;

import java.util.Map;

/**
 *
 * @author mark
 */
public class SlowPrinter implements Runnable{

    
    private final Map m_list ;
    private final int m_maxSize  ;
    private final int index = 0  ;
    private final MainForm m_form  ; 
    
    private final String m_Key[] ;
    private final String [] val ;
    private  int charindex ; 
    private final  int m_entry ;
    private boolean stop = false ;
    

// Constructor 
    
    
    public SlowPrinter(Map<String, String> aMap ,String[] aKey ,  MainForm m ,int entry )
    {
        this.charindex = 0;
        m_list = aMap ;
        m_form = m ;
        m_Key = aKey ;
        m_maxSize = m_list.size() ;
        val = new String[m_maxSize] ;
        m_entry = entry ;
        
        for(int x = 0 ; x < m_maxSize; x++)
        {
         val[x]  = (String)m_list.get(aKey[x]) ;
        }
        
    }

      
    public void stop(){
      
      if(m_entry==m_maxSize-1)
      {
      this.m_form.setbuttonText("Finished");
      
      }
      stop = true ; 
     
      
    }
   
    public void begin(){
        stop = false ;
    }

    @Override
        public void run() {

        
          if (m_entry < m_maxSize)
                {

                    String msg = val[m_entry] ;
                    String x ;   
                    
                    
                    for (charindex = 0 ; charindex < msg.length(); charindex ++)
                      {
                         if(!stop==true)
                         {
                          try {
                            x=""+ msg.charAt(charindex) ;
                            this.m_form.setPtext(x);
                                  if(charindex==msg.length()-1)
                                   {
                                       this.m_form.stopTimer();
                                   }
                                  Thread.sleep(50);
                                } catch (InterruptedException ex) {
                                 
                                    System.out.println("Exception caught");
                                    Thread.currentThread().interrupt();
                                 
                                 
                            }
                         }


                        }
                   }

                } 

       }