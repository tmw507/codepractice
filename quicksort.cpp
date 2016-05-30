# include <stdio.h>
# include <stdlib.h>
# include <time.h>

# define bool int

void quickSort(int *, int, int);
int kSelect(int*, int, int, int);

bool hasArrayTwoCandidates(int A[], int arr_size, int sum)
{
	int l, r;

	/* Sort the elements */
	quickSort(A, 0, arr_size-1);
  
    for(int i=0; i<arr_size; i++){
        printf("%d, ", A[i]);
    }
    printf("\n");
	/* Now look for the two candidates in the sorted 
	array*/
	l = 0;
	r = arr_size-1; 
	while (l < r)
	{
		if(A[l] + A[r] == sum)
			return 1; 
		else if(A[l] + A[r] < sum)
			l++;
		else // A[i] + A[j] > sum
			r--;
	} 
	return 0;
}

/* Driver program to test above function */
int main()
{
    srand(time(NULL));
	int A[] = {1, 4, 45, 6, 10, -8};
	int n = 16;
	int arr_size = 6;
	
	/*
	if( hasArrayTwoCandidates(A, arr_size, n))
		printf("Array has two elements with sum 16");
	else
		printf("Array doesn't have two elements with sum 16 ");
    */
    int k=3;
    int kValue = kSelect(A,0,arr_size-1, k);
    printf("%d:%d",k,kValue);
	getchar();
	return 0;
}

/* FOLLOWING FUNCTIONS ARE ONLY FOR SORTING 
	PURPOSE */
void exchange(int *a, int *b)
{
    if(a==b) return;
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

int partition(int A[], int si, int ei, int r)
{
	int sortedPos = si;
	exchange(&A[ei], &A[r]);
	for(int i=si; i<ei; i++){
	    if(A[i] <= A[ei]){
	        exchange(&A[i], &A[sortedPos]);
	        sortedPos++;
	    }
	}
	exchange(&A[sortedPos],&A[ei]);
	return sortedPos;
}

/* Implementation of Quick Sort
A[] --> Array to be sorted
si --> Starting index
ei --> Ending index
*/
void quickSort(int A[], int si, int ei)
{

	int pi; /* Partitioning index */
	if(si < ei)
	{
	    int r = rand() % (ei-si+1) + si;
		pi = partition(A, si, ei,r);
		quickSort(A, si, pi - 1);
		quickSort(A, pi + 1, ei);
	}
}

int kSelect(int A[], int si, int ei, int k){
    int r = rand() % (ei-si+1) + si;
    int pi = partition(A, si, ei,r);
    if(pi == k) return A[k];
    if(pi<k){
       return kSelect(A,pi+1, ei, k);
    }else{// pi>k
       return kSelect(A,si, pi-1, k);    
    }
}
