import java.util.*;
	import java.lang.String;
	import java.io.*;
	class Hangman {
	    public static void main(String args[]) throws IOException {
	        Scanner scan = new Scanner(System. in ); //Scanner method (Input)
	        String s1 = new String(); //String Declartion Method
	        DataInputStream in = new DataInputStream(System. in );
	        int i, p = 1;
	        do {
	            //Ask input
	            System.out.println("Enter Your Sentence\n");

	            //Scan input in string "s1"
	            s1 = scan.nextLine();

	            //Display input
	            System.out.println("\n" + s1 + "\n");

	            //Trim
	            s1 = s1.trim();

	            //Covert lower
	            s1 = s1.toLowerCase();

	            //Extract the Str length
	            int n = s1.length();

	            //Copies string to array "s2"
	            char s2[] = new char[n];
	            char s3[] = new char[n];
	            s2 = s1.toCharArray();
	            s3 = s1.toCharArray();

	            //Generates a Random Number for hiding letters
	            int randomInt = (int)(n * Math.random());
	            while (randomInt == 0) {
	                randomInt = (int)(n * Math.random());
	            }
	            /*
	//Display all the letters of strings stored in s2 array
	for(i=0;i<n;i++){
	System.out.println(s2[i]+":"+(i+1));
	}
	System.out.println("\n\n");
	*/
	            //Hidding characters and storing their location in Location array

	            int location[] = new int[randomInt];
	            for (i = 0; i < randomInt; i++) {
	                int arrayrandomInt = (int)(n * Math.random());
	                location[i] = arrayrandomInt;
	                s2[arrayrandomInt] = '_';
	            }

	            //Displays the Hangman sequence
	            System.out.println("\n\nYour Game:\t\tLives:3\n");
	            for (i = 0; i < n; i++) {
	                System.out.print(s2[i] + " ");
	            }
	            //Gives Info of total hidden letters
	            System.out.println("\n\nHidding " + randomInt + " spaces out of " + n + "spaces\n");

	            //Displays the Location Number of hidden characters
	            System.out.println("\nWords hidden at Location ");
	            for (i = 0; i < randomInt; i++) {
	                System.out.print((location[i] + 1) + "  ");
	            }
	            int count = randomInt;
	            int lives = 3;
	            int flag = 0;
	            /////////////////////////////////////////////////////////////////

	            do {
	                do {

	                    System.out.println("\nEnter the position of character: ");
	                    p = scan.nextInt();
	                    p = p - 1;

	                    for (i = 0; i < randomInt; i++) {
	                        if (p == location[i]) {
	                            flag = 1;
	                            break;
	                        } else {
	                            flag = 0;
	                        }
	                    }
	                    if (flag == 0) {
	                        System.out.println("ERR..ERROR..There is no hidden character at \n Position " + (p + 1) + "Please try again");
	                    }
	                } while (flag != 1);
	                flag = 0;


	                String b1 = new String();
	                ///////////////////////////////////////////////////////////////////
	                while (flag != 1) {

	                    System.out.println("\nEnter Your character: ");
	                    b1 = in .readLine();
	                    char a1 = s3[p];
	                    char a2 = b1.charAt(0);
	                    //System.out.println("a1="+a1+"\na2="+a2);
	                    if (a1 == a2) {
	                        s2[p] = a2;
	                        flag = 1;
	                        count--;
	                        System.out.print("Count=" + count);
	                    } else {
	                        flag = 0;
	                    }
	                    if (flag == 0) {
	                        lives = lives - 1;
	                        System.out.println("Oops! you are wrong Please try again");
	                        System.out.println("*********Lives Left:" + lives + "**********");
	                    }
	                    if (lives == 0) {
	                        break;
	                    }
	                }
	                if (flag == 1) {
	                    System.out.print("Great Well Done\n\n");
	                    for (i = 0; i < n; i++) {
	                        System.out.print(s2[i] + " ");
	                    }
	                }
	            } while (lives != 0 && count > 0);
	            if (lives == 0 || count < 0) {
	                System.out.print("Sorry you lost Answer was\n\n");
	                System.out.print(s1);
	            } else {
	                System.out.print("Congrats\n\n");
	            }
	            p = 1;
	            System.out.print("Want to play again\n\n");
	            p = scan.nextInt();
	            if (p == 1) {
	                continue;
	            } else {
	                break;
	            }
	        } while (p == 1);
	    }
	}