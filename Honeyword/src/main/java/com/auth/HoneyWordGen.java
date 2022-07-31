/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth;

/**
 *
 * @author Sachin
 */
import java.util.ArrayList;
import java.util.Random;

public class HoneyWordGen {
	private static int tn = 5;
	
	private static float p1 = 0.10f;
	private static float p2 = 0.40f;
	private static float p3 = 0.50f;
	
	private static float q = 0.03f;
	
	
	private static float nL = 0;
	private static float nD = 0;
	private static float nS = 0;
	
	
	private static ArrayList<String> high_probablity_passwords = new ArrayList<>();
	static String ans;
	
	
	private static String noise_list(int n)
	{
		char chars[] = (getUpper() + getLower() + getDigits() + getPunctuation()).toCharArray();
		
		int nchars = chars.length;
		
		String L = "";
		
		for(int i=0;i<n;i++)
		{
			char W[] = {};
			Random random = new Random();
			
			int k = random.nextInt(18) + 1;
			for(int j=0;j<k;j++)
			{
				W[j] = chars[random.nextInt(nchars)];
				
			}
			L = W.toString(); //CHECK
		}
		return L;
	}
	
	private static String tough_nut()
	{
		char chars[] = (getUpper() + getLower() + getDigits() + getPunctuation()).toCharArray();
	
		int nchars = chars.length;
	//	System.out.println("nChars Length: "+String.valueOf(nchars));
		
		String W = "";
		int k=10;
		Random random = new Random();
		for(int j=0;j<k;j++)
		{
			W = W + chars[random.nextInt(nchars)];
		}
		
		
		//System.out.println("Returning " + W);
		return W;
	}
	
private static boolean syntax(char p[])
{
	int L=0;
	int D = 0;
	int S = 0;
	
	for(char c:p){
		
		if(getUpper().contains(String.valueOf(c))||getLower().contains(String.valueOf(c))){
			L += 1;
		}
		else if(getDigits().contains(String.valueOf(c))){
			D += 1;
		}
		else{
			S +=1;
		}
	}
	if(L>nL&&D>nD&&S>nS)
		return true;
	return false;
	
}
	

private static String make_password(ArrayList<String> pw_list)
{
	Random random = new Random();
	int nextrand = random.nextInt(10);
	if(nextrand<tn){
		
		//System.out.println("Returning toughnut " + String.valueOf(nextrand) + " tn: " + String.valueOf(tn));
		return tough_nut();
		
	}
	
	int random_choice = random.nextInt(pw_list.size());
	int k = pw_list.get(random_choice).length();
	ArrayList<String> L = new ArrayList<>();
	
	for(String pw:pw_list)
	{
		if(pw.length()==k){
			//System.out.println("adding" + pw);
			L.add(pw);
		}
	}
	nL = L.size();
	//System.out.println("Size of nL:"+String.valueOf(nL));
	int row = random.nextInt(Math.round(nL));
	//System.out.println("Size of row:"+String.valueOf(row));
	ans = String.valueOf(L.get(row).charAt(0));
	//System.out.println("Answer is : " + ans);
	int j = 1;
	while(j<k)
	{
		float p = random.nextFloat();
		String action ="";
		if(p<p1)
			action = "action_1";
		else if(p<(p1+p2))
			action = "action_2";
		else
			action = "action_3";
		
		if(action.equals("action_1"))
		{
			row = random.nextInt(Math.round(nL));
			ans = ans + String.valueOf(L.get(row).charAt(j));
			//System.out.println("Adding ans : " + ans);
			j = j+1;
		
		}
		else if(action.equals("action_2")){
			
			ArrayList<Integer> LL = new ArrayList<>();
			for(int i=0;i<nL;i++)
			{
				if(L.get(i).charAt(j-1)==ans.charAt(ans.length()-1))
					LL.add(i);
			}
			row = LL.get(random.nextInt(LL.size()));
			ans = ans + String.valueOf(L.get(row).charAt(j));
			//System.out.println("Adding ans : " + ans);
			j = j+1;
			//TODO: ACTION_2
			
		} 
		else if(action.equals("action_3"))
		{
			ans = ans + String.valueOf(L.get(row).charAt(j));
			//System.out.println("Adding ans : " + ans);
			j = j+1;
		}
		
	}
	
	return ans;
	
		
	
	
}
	
private static ArrayList<String> generate_passwords(int n,ArrayList<String> pw_list)
{
	ArrayList<String> ans = new ArrayList<>();
	for(int i=0;i<n;i++){
		String pw = make_password(pw_list);
		ans.add(pw);
	//	System.out.println("adding string in ans : "+pw);
		
	}
	
	
	
	return ans;
	
}
	
public static void main(String[] args)
{
	initList();
	int n;
	//if(args[0].length()>1)
		//n = Integer.valueOf(args[0]);
	//else
		n = 10;
	
	ArrayList<String> pw_list;
	pw_list = high_probablity_passwords;
	
	ArrayList<String> new_passwords = generate_passwords(n,pw_list);
	
	for(String s:new_passwords)
		System.out.println("Generated Password: "+s);
	
	
		
}
	
	public static void initList()
	{
		high_probablity_passwords.add("root");
		
		  high_probablity_passwords.add("1234567");
		  high_probablity_passwords.add("12345678");
		  high_probablity_passwords.add("123asdf");
		  high_probablity_passwords.add("Admin");
		  high_probablity_passwords.add("admin");
		  high_probablity_passwords.add("administrator");
		  high_probablity_passwords.add("asdf123");
		  high_probablity_passwords.add("backup");
		  high_probablity_passwords.add("backupexec");
		  high_probablity_passwords.add("changeme");
		  high_probablity_passwords.add("clustadm");
		  high_probablity_passwords.add("cluster");
		  high_probablity_passwords.add("compaq");
		  high_probablity_passwords.add("default");
		  high_probablity_passwords.add("dell"); high_probablity_passwords.add("dmz");
		  high_probablity_passwords.add("domino");
		  high_probablity_passwords.add("exchadm");
		  high_probablity_passwords.add("exchange");
		  high_probablity_passwords.add("ftp");
		  high_probablity_passwords.add("gateway");
		  high_probablity_passwords.add("guest");
		  high_probablity_passwords.add("lotus");
		  high_probablity_passwords.add("money");
		  high_probablity_passwords.add("notes");
		  high_probablity_passwords.add("office");
		  high_probablity_passwords.add("oracle");
		  high_probablity_passwords.add("pass");
		  high_probablity_passwords.add("password");
		  high_probablity_passwords.add("password!");
		  high_probablity_passwords.add("password1");
		  high_probablity_passwords.add("print");
		  high_probablity_passwords.add("qwerty");
		  high_probablity_passwords.add("replicate");
		  high_probablity_passwords.add("seagate");
		  high_probablity_passwords.add("secret");
		  high_probablity_passwords.add("sql");
		  high_probablity_passwords.add("sqlexec");
		  high_probablity_passwords.add("temp");
		  high_probablity_passwords.add("temp!");
		  high_probablity_passwords.add("temp123");
		  high_probablity_passwords.add("test");
		  high_probablity_passwords.add("test!");
		  high_probablity_passwords.add("test123");
		  high_probablity_passwords.add("tivoli");
		  high_probablity_passwords.add("veritas");
		  high_probablity_passwords.add("virus"); high_probablity_passwords.add("web");
		  high_probablity_passwords.add("www");
		  high_probablity_passwords.add("KKKKKKK");
		 
	}
	
	public static String getUpper() {
	    return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

	public static String getLower() {
	    return "abcdefghijklmnopqrstuvwxyz";
	}

	public static String getDigits() {
	    return "0123456789";
	}

	public static String getPunctuation() {
	    return ".," ;// Don't really know what this should return
	}
	
}
