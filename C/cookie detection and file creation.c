#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<time.h>
#include<stdlib.h>

void main()
{
    char det;
    char msg[100];
    char f_name[20];
    int i,k,t,st,ch;
    FILE *fp,*cok;	//Declare file variable
//Time Function Starts//

    time_t now; 					  //time block
    struct tm *d; 					  //time block
    char li[13];    	       	      //time block
    char day[13];
    time(&now);    					  //time block
    d = localtime(&now);       	      //time block
    strftime(li, 15, "%w", d);  	  //time block
    t=atoi(li);							//convert string to int
    strftime(day, 15, "%A", d);
//Time Function  Ends//

//File Function Starts//
    cok=fopen("cookie.dat","r");
	 if(cok==NULL)
	 {   clrscr();
        gotoxy(51,25);
		  printf("-Created by Abdullah Sorathia");
		  gotoxy(1,1);
		  printf("\t\t **********Cannot find Cookie file*************\a\a\a\n");
		  printf("\t\t **********Please wait while Cookie file is created*************\a\a\a\n");
		  cok=fopen("cookie.dat","w");
		  fprintf(cok,"%s","t.txt");
		  fclose(cok);
		  cok=fopen("cookie.dat","r");
		  fgets(msg,100,cok);
		  fclose(cok);
		  printf("\t\t **********Cookie file created Successfully*************\a\a\a\n");
        getch();
	 }
	 else
	 {
		  fgets(msg,100,cok);
		  fclose(cok);
	 }

	 fp=fopen(msg,"r");	//Open file
	 if(fp==NULL)
	 {   clrscr();

		  gotoxy(51,25);
		  printf("-Created by Abdullah Sorathia");
		  gotoxy(1,1);
		  printf("\n\n\n\n\n\n\n\n\n\n\t\t*********No such file exist file exist*************\a\a\a\n");
		  printf("\t\t **********Cannot find the '%s'*************\a\a\a\n",msg);
		  printf("\t *******Do you want to create if yes press 0 for no press 1********\a\a\a\n");
        printf("\t **********And if exist press 2 to enter the file name*************\a\a\a\n");
        scanf("%d",&i);
        if(i==0)
        {
            clrscr();
            gotoxy(51,25);
            printf("-Created by Abdullah Sorathia");
            gotoxy(1,1);
            printf("Enter Details\n");
            printf("File Name: \n");
            scanf("%s",&f_name);
            printf("\nCreating File.\nPlease Wait.......\n");
            fp=fopen(f_name,"w");
            fprintf(fp,"%s",".");
            printf("\nFile Created Successfull...\n");
            fclose(fp);
            cok=fopen("Cookie.dat","w");
            fprintf(cok,"%s",f_name);
            fclose(cok);
            fp=fopen(f_name,"r");
            i=0;
            while(!feof(fp))
            {
                det=getc(fp);
                if(det=='.')
                {
                    i++;
                }
            }
            fclose(fp);

            if(i==1)
            {
                printf("\n\nThe file Seems to be Empty\nDo you Want to insert some text\n if yess press 0 or else press 1\n");
                scanf("%d",&i);
                if(i==0)
                {
                    clrscr();
                    gotoxy(51,25);
                    printf("-Created by Abdullah Sorathia");
                    gotoxy(1,1);
                    printf("Please enter your content..\n");
                    printf("In following format\nnumberdtata1;data2;date3....datan\n");
                    fp=fopen(f_name,"w");
                    printf("How many lines you want to print? ");
                    scanf("%d",&i);
                    for(k=0; k<i; k++)
                    {
                        scanf("%s",&msg);
                        fprintf(fp,"%s",msg);
                        fprintf(fp,"\n");
                    }
                    printf("\nMsg Written sussefully...");
                    printf("\nProgram will now close  Please restart the program to detect your file");
                }
            }
        }
        else if(i==2)
        {
A:

            clrscr();
            gotoxy(51,25);
            printf("-Created by Abdullah Sorathia");
            gotoxy(1,1);
            printf("Enter Your File name: ");
            scanf("%s",&f_name);
            cok=fopen("Cookie.dat","w");
            fprintf(cok,"%s",f_name);
            fclose(cok);
            cok=fopen("Cookie.dat","r");
            fgets(msg,100,cok);
            fclose(cok);
            fp=fopen(msg,"r");
            if(fp==NULL)
            {
                printf("\n\n\n\n\n\n\n\n\n\n\t\t*********No such file exist file exist*************\a\a\a\n");
                printf("\t*******Do you want to try again 1 for yess and 2 for no********\a\a\a\n");
                scanf("%d",&i);
                if(i==1)
                {
                    goto A;
                }
            }
            else
                goto B;

        }
    }
    else
    {
B:      gotoxy(51,25);
		  printf("-Created by Abdullah Sorathia");
		  gotoxy(1,1);
        printf("File found '%s' do you want\nto read that file\npress '0' for yes \nPress '1' for no\n",msg);
        scanf("%d",&ch);
        if(ch==0)
        {
            clrscr();
            gotoxy(51,25);
            printf("-Created by Abdullah Sorathia");
            gotoxy(1,1);
            printf("-----------------------------\n");
            printf("  Time Table for: %s\n",day);
            printf("-----------------------------\n");
            while(!feof(fp))	//Print the charaters of the file till EOF
            {
                fgets(msg,100,fp); //Get String from fp and store in msg of siz 100 character
                st=atoi(msg);       //convert string to int
                if(st==t)
                {
                    i=strlen(msg)-1;   //calculate the size of character in msg-1
                    for(k=0; k<=i; k++)
                    {
                        msg[k]=msg[k+1];
                    }
                    i--;
                    if(msg[i]=='\n')   //If any new line charater found.
                    {
                        msg[i]='\0';	 //if any new line chacter forund is replace by \0
                    }
                    for(k=0; k<=i; k++)
                    {
                        if(msg[k]==';')   //If any ';' charater found is replaced by a new line.
                        {
                            msg[k]='\n';
                        }
                    }
                    puts(msg);         //Dispaly the string store in msg
                }
            }
            printf("-----------------------------\n");
        }
        else
        {
            printf("closing t1.txt\n");
            fclose(fp);        //Close the file
        }
    }
//File Ends//
}