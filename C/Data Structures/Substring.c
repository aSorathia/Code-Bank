/* Substring in c programming: c programming code to find a substring
from a given string and for all substrings of a string, For example
substrings of string "the" are "t", "th", "the", "h", "he" and "e" to
find substring we create our own c substring function which returns a
pointer to string. String address, length of substring required and position
from where to extract substring are the three arguments passed to function.
String.h does not contain any library function to directly find substring.*/
  
#include <stdio.h>
#include <malloc.h>

char* substring(char*, int, int);

int main()
{
   char string[100], *pointer;
   int position, length;

   printf("Enter a string\n");
   gets(string);

   printf("Enter the position and length of substring\n");
   scanf("%d%d",&position, &length);

   pointer = substring( string, position, length);

   printf("Required substring is \"%s\"\n", pointer);

   free(pointer);

   return 0;
}

/*C substring function: It returns a pointer to the substring */

char *substring(char *string, int position, int length)
{
   char *pointer;
   int c;

   pointer = malloc(length+1);

   if (pointer == NULL)
   {
      printf("Unable to allocate memory.\n");
      exit(EXIT_FAILURE);
   }

   for (c = 0 ; c < position -1 ; c++)
      string++;

   for (c = 0 ; c < length ; c++)
   {
      *(pointer+c) = *string;
      string++;
   }

   *(pointer+c) = '\0';

   return pointer;
}