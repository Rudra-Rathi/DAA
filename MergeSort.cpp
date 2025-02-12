#include <iostream>
#include <vector>
using namespace std;

int mergeOperations = 0;
int sortOperations = 0;

void merge(vector<int> &arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    vector<int> L(n1), R(n2);

    for (int i = 0; i < n1; i++) {
        L[i] = arr[left + i];
        mergeOperations++;
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
        mergeOperations++;
    }

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        mergeOperations++;
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
        mergeOperations++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
        mergeOperations++;
    }
}

void mergesort(vector<int> &arr, int left, int right) {
    if (left < right) {
        sortOperations++;
        int mid = left + (right - left) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

int main() {
    int n;
    cout << "Enter the size of the array: ";
    cin >> n;
    if (n <= 0) {
        cout << "Array size must be greater than 0." << endl;
        return 0;
    }
    
    vector<int> arr(n);
    cout << "Enter the elements of the array: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "The unsorted array is: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    mergesort(arr, 0, n - 1);
    
    cout << "The sorted array is: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    cout << "Number of merge operations: " << mergeOperations << endl;
    cout << "Number of sort operations: " << sortOperations << endl;
    cout << "Time Complexity: O(n log n)" << endl;
    
    return 0;
}