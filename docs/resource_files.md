The main/resources directory contains some required files and some configuration files
 
 These are:
 
 ___cmp-automation.xml___
 
 This is a base spring configuration file
 
  ___log4j2.xml___
  
  This is the log4j configuration file
  
  ___*-configuration.xml___
  
  These files (local-configuration, staging-configuration etc... ) contain various pieces of information such as the talend server and the location of the catsynclisting.sh file on the server
  
  To setup a new file just copy one of these configuration files and rename it to {something}-configuration.xml
  
  ___Other files___
  
  The other files in this directory (catalog-sup.csv and pb_bflab1.dsa) will be removed soon 