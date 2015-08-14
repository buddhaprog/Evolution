/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonrepeatedcharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import static nonrepeatedcharacter.NonRepeatedCharacter.firstNonRepeatedCharacter;

/**
 *
 * @author Rob
 */
public class NonRepeatedCharacterLinkedHashMap {
    public static void main(String[] args) {
         System.out.println(" Please enter the input string :" );
        Scanner in = new Scanner (System.in);
        String s=in.nextLine();
        char c=getFirstNonRepeatedChar(s);
        System.out.println("The first non repeated character is :  " + c);
  }
  
  public static char getFirstNonRepeatedChar(String str) { Map<Character,Integer> counts = new LinkedHashMap<>(str.length()); for (char c : str.toCharArray()) { counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1); } for (Entry<Character,Integer> entry : counts.entrySet()) { if (entry.getValue() == 1) { return entry.getKey(); } } throw new RuntimeException("didn't find any non repeated Character"); }


}