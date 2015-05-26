/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author dumiduh
 */
public class Controller {
private ArrayList<NodeDTO> nodes;
private int noNodes;
private int nodeSelection;
private final String FINDPIDSCRIPT="sh conf/findpid.sh"; 
private final String KILLPROSSCRIPT="sh conf/killprocess.sh";
private final String FINDANDKILL="sh "+new File("").getAbsolutePath()+"/conf/findandkill.sh";
private final String NODESXML="conf/Nodes.xml";
private String PID;

public Controller()
{
    ConfigurationReader confReader = new ConfigurationReader(NODESXML);
    confReader.readConfig();
    nodes=confReader.getNodes();
    noNodes=nodes.size();
    
    Random ran = new Random();
    nodeSelection = ran.nextInt(noNodes);
}


public void findPID()
{   
    
    
    String cmd =FINDPIDSCRIPT+" "+nodes.get(nodeSelection).getKeyPath()+" "+nodes.get(nodeSelection).getUsername()+" "+nodes.get(nodeSelection).getIp()+" "+nodes.get(nodeSelection).getKeyword();
    ShellExecutor executor = new ShellExecutor(cmd);
       
    PID = executor.execute();
    

    //write check to see if valid.
    
    String[] pidV= PID.split("\\s+");
    PID=pidV[0];
    
}

public void killProcess()
{
    // to be implimented. 
}

public void findAndKill()
{
    String cmd =FINDANDKILL+" "+nodes.get(nodeSelection).getKeyPath()+" "+nodes.get(nodeSelection).getUsername()+" "+nodes.get(nodeSelection).getIp()+" "+nodes.get(nodeSelection).getKeyword();
    ShellExecutor executor = new ShellExecutor(cmd);
    System.out.println("process killed on "+nodes.get(nodeSelection).getIp()+" \t for keyword "+nodes.get(nodeSelection).getKeyword());
    String result = executor.execute();
}

}
