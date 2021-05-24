#include <stdio.h>
#include <stdlib.h>

int sum_of_mult(int multiple, int limit);

int main(int argc, char const *argv[])
{
    char *end     = NULL;
    int limit     = strtol(argv[1], &end, 10);

    int sum_of_mult3  = sum_of_mult(3 , limit);
    int sum_of_mult5  = sum_of_mult(5 , limit);
    int sum_of_mult15 = sum_of_mult(15, limit);

    printf("P1: %i\n", sum_of_mult3 + sum_of_mult5 - sum_of_mult15); // P1: 233168

}

int sum_of_mult(int multiple, int limit){

    int result = 0;

    for (int i = multiple; i < limit ; i+=multiple)
    {
        result += i;
    }
    
    return result;
}