
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAll();
    }
    
    public void testUniqueIPs(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println("There are "+la.countUniqueIPs()+" Unique IP addresses");
    }
    
    public void testcountUniqueIPsinRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println("There are "+la.countUniqueIPsinRange(200,299)+" Unique IP addresses");
    }
    public void testUniqueIPVisit(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        ArrayList<String> l1 = la.uniqueIPVisitsOnDay("Mar 24");
        for(String s:l1){
            System.out.println(s);
        }
        System. out.println("done------");
        ArrayList<String> l2 = la.uniqueIPVisitsOnDay("Sep 27");
        for(String s:l2){
            System.out.println(s);
        }
        System.out.println(l2.size());
    }
        
    public void testHigherNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAllHigherThanNum(400);
    }
    
    public void testcountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap<String,Integer> hm = la.countVisitsPerIP();
        int count = hm.size();
        System.out.println(count);
        int visit = la.mostNumberVisitsByIP(hm);
        System.out.println(visit);
        ArrayList<String> al = la.iPsMostVisits(hm,visit);
        System.out.println(al);
        HashMap<String,ArrayList<String>> hmdays =la.iPsForDays();
        System.out.println(hmdays);
        String days = la.daysWithMostIPVisits(hmdays);
        System.out.println(days);
        ArrayList<String> visits =  la.daysWithMostIPVisits(hmdays,"Sep 30");
        System.out.println(visits);
    }
}
