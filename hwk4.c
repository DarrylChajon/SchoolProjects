// Homework assignment where I created a program that would take a specified number string of characters, check if the input is actually a series of chars, 
// then sort them in order.

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
//swap function
void swap(char *x, char *y) {
   char temp = *x;
   *x = *y;
   *y = temp;
}
//sort function
void sort(char*a, int size) {
   char *end = a + size;
   char *i, *j;
   for (i = a; i < end - 1; i++) {
      for (j = i + 1; j < end; j++) {
         if (*i > *j) {
            swap(i, j);
         }
      }
   }
}

int main() {
   int n, i, count = 0;
   char *str;
   printf("Enter amount of characters: ");
   scanf("%d", &n);
   //allocating appropriate amount of memory
   str = (char*)malloc(n * sizeof(char));
   if (str == NULL) {
      printf("Memory allocation failed\n");
      return 1;
   }
   printf("Enter characters(no spaces, tabs, or symbols): ");
   while (count < n) {
      char c;
      scanf(" %c", &c);
      //isalpha function to check if entered value is a char
      if (isalpha(c)) {
         *(str + count) = c;
         count++;
      } else {
         printf("Invalid character, only letters please\n");
         break;
      }
   }
   sort(str, n);
   printf("Sorted: ");
   for (i = 0; i < n; i++) {
      putchar(*(str + i));
   }
   putchar('\n');
   free(str);
   return 0;
}
