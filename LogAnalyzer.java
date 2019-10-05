
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile() {
         // complete method
         FileResource fr = new FileResource();
         for(String s:fr.lines()){
             WebLogParser wb = new WebLogParser();
              LogEntry le = wb.parseEntry(s);
              records.add(le);
            }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> UniqueIPs = new ArrayList<String>();
             for(LogEntry le: records){
             String IPs = le.getIpAddress();
             if(!UniqueIPs.contains(IPs)){
                 UniqueIPs.add(IPs);
                }
             }
             return UniqueIPs.size();
     }
     
     public int countUniqueIPsinRange(int low,int high){
         ArrayList<String> UniqueIPs = new ArrayList<String>();
             for(LogEntry le: records){
             String IPs = le.getIpAddress();
             int statusBit = le.getStatusCode();
             if(statusBit>=low&&statusBit<=high){
             if(!UniqueIPs.contains(IPs)){
                 UniqueIPs.add(IPs);
                 System.out.println(IPs);
                }
             }
             }
             return UniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le: records){
             int statusBit = le.getStatusCode();
             if(statusBit>num){
                 System.out.println(le);
                }
             }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> UniqueIPs = new ArrayList<String>();
         for(LogEntry le: records){
             Date d = le.getAccessTime();
             String str = d.toString();
             String day = str.substring(4,10);
             String IPs = le.getIpAddress();
             if(someday.equals(day)){
                 if(!UniqueIPs.contains(IPs)){
                     UniqueIPs.add(IPs);
                 }
             }
            }
         return UniqueIPs;
        }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         for(LogEntry le : records){
             String IPs = le.getIpAddress();
             if(!counts.containsKey(IPs)){
                 counts.put(IPs,1);
             }
             else{
                 int value = counts.get(IPs);
                 counts.put(IPs,value+1);
             }
         }
         return counts;
     }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
         int max=0;
             for(String s:counts.keySet()){
             if(max<counts.get(s)){
                 max=counts.get(s);
             }
             }
             return max;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts,int max){
         ArrayList<String> al = new ArrayList<String>();
             for(String s:counts.keySet()){
                 if(counts.get(s)==max){
                 al.add(s);
                 }
             }
            return al;
     }
     
     public HashMap<String,ArrayList<String>> iPsForDays(){
         HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
         for(LogEntry le : records){
             Date d = le.getAccessTime();
             String str = d.toString();
             String day = str.substring(4,10);
             String IPs = le.getIpAddress();
                 ArrayList<String> list = new ArrayList<String>();
             if(hm.containsKey(day)){
                 list = hm.get(day);
                 list.add(IPs);
                 hm.put(day,list);
             }
             else{
                 list.add(IPs);
                 hm.put(day,list);
                }
            }
            return hm;
        }
     
     public String daysWithMostIPVisits(HashMap<String,ArrayList<String>> hmdays){
         int max=0;
         String s = " ";
         for(String day:hmdays.keySet()){
             if(max<hmdays.get(day).size()){
                 max=hmdays.get(day).size();
                 s = day;
                }
            }
            return s;
        }
        public ArrayList<String> daysWithMostIPVisits(HashMap<String,ArrayList<String>> hmdays,String day){
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> parser = hmdays.get(day);
            int max=0;
            HashMap<String,Integer> hm = new HashMap<String,Integer>();
            for(String s : parser){
                if(hm.containsKey(s)){
                    int value = hm.get(s);
                    hm.put(s,value+1);
                }
                else{
                    hm.put(s,1);
                }
            }
            for(String s : hm.keySet()){
                if(max<hm.get(s)){
                    max=hm.get(s);
                }
            }
            for(String s : hm.keySet()){
                if(max==hm.get(s)){
                   list.add(s);
                }
            }
            return list;
        
        }
}
