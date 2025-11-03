Perfect 👍 Let’s go through your **entire Kruskal’s Algorithm program** **line by line**, explaining what each part does and why.

---

## 🧩 OVERVIEW

This C program implements **Kruskal’s Algorithm** to find the **Minimum Spanning Tree (MST)** of a connected, weighted, undirected graph.
It uses:

* An **edge list representation** of the graph.
* **Disjoint Set Union (Union-Find)** data structure to detect cycles efficiently.

---

## 🧠 Line-by-Line Explanation

---

### 🏗️ Header Files and Constants

```c
#include<stdio.h>
#include<limits.h>
#include<stdlib.h>
```

* `stdio.h` → for input/output functions (`printf`, `scanf`).
* `limits.h` → provides constants like `INT_MAX`.
* `stdlib.h` → for `exit()` function.

---

```c
#define MAX 50
#define INF INT_MAX
#define no_edge -1
```

* `MAX` = maximum number of vertices allowed (50).
* `INF` = a symbolic representation of infinity (using `INT_MAX`).
* `no_edge = -1` = used for identifying the absence of an edge.

---

```c
int n=0 , edge_count=0;
```

* `n` → number of vertices.
* `edge_count` → number of edges in the graph.

---

### 💡 Defining Structures

```c
struct Edge {
    int u, v, w;
};
```

* Represents an edge:

  * `u` = starting vertex.
  * `v` = ending vertex.
  * `w` = weight of the edge.

---

### 📦 Global Arrays

```c
struct Edge edges[MAX * (MAX - 1) / 2];
struct Edge mst[MAX];
```

* `edges[]` → stores all edges of the graph.
* `mst[]` → stores edges that are part of the final MST.

> For `n` vertices, maximum edges in an undirected graph = `n * (n - 1) / 2`.

---

### ⚙️ DSU (Disjoint Set Union) Support Arrays

```c
int parent[MAX];
int rank_arr[MAX];
```

* `parent[i]` → stores parent of vertex `i`.
* `rank_arr[i]` → stores depth/rank of tree rooted at `i` (used to keep the trees shallow during union).

---

### 📊 MST and Flags

```c
int mst_edges = 0;
int min_cost = 0;
int mst_found = 0;
```

* `mst_edges` → number of edges in the MST.
* `min_cost` → total weight of the MST.
* `mst_found` → indicates whether MST has been calculated.

---

## 🔍 UNION-FIND FUNCTIONS

### `find()` → Find the parent (root) of a vertex

```c
int find(int x)
{
    if (parent[x] != x)
        parent[x] = find(parent[x]);
    return parent[x];
}
```

* This finds the **representative** (root) of the set that `x` belongs to.
* Uses **path compression** → makes future lookups faster by directly connecting nodes to their root.

🧠 Example:
If `parent[2] = 1` and `parent[1] = 0`, then after calling `find(2)`, it sets `parent[2] = 0`.

---

### `union_sets()` → Combine two sets

```c
void union_sets(int x, int y)
{
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY)
        return;
```

* Find the roots of `x` and `y`.
* If they have the same root → they are already connected (adding an edge would form a cycle), so we return.

---

```c
    if (rank_arr[rootX] < rank_arr[rootY])
        parent[rootX] = rootY;
    else if (rank_arr[rootX] > rank_arr[rootY])
        parent[rootY] = rootX;
    else {
        parent[rootY] = rootX;
        rank_arr[rootX]++;
    }
}
```

* If roots are different, we connect them.
* Always attach the **smaller tree under the larger one** (union by rank) to keep the trees balanced.
* If ranks are equal, pick one root arbitrarily and increase its rank.

---

## 🧮 SORTING THE EDGES (Bubble Sort)

```c
void sort_edges()
{
    for (int i = 0; i < edge_count - 1; i++)
    {
        for (int j = 0; j < edge_count - i - 1; j++)
        {
            if (edges[j].w > edges[j + 1].w)
            {
                struct Edge temp = edges[j];
                edges[j] = edges[j + 1];
                edges[j + 1] = temp;
            }
        }
    }
}
```

* Sorts edges in ascending order of their weight `w`.
* Kruskal’s algorithm always considers the smallest edge first.

🧠 Note: Bubble sort is simple but not efficient; you could replace it with `qsort()` for large graphs.

---

## 📥 READING GRAPH FROM USER

```c
void read()
{
    printf("Enter the number of vertices (max %d): ", MAX);
    if (scanf("%d", &n) != 1 || n <= 1 || n > MAX)
    {
        printf("Invalid vertex count! Must be between 2 and %d.\n", MAX);
        n = 0;
        return;
    }
```

* Prompts user for number of vertices (`n`).
* Checks for valid input (between 2 and MAX).

---

```c
    edge_count = 0;
    printf("\nEnter edges in the format: <source> <destination> <weight>\n");
    printf("Example:\n1 2 5\n1 3 2\n2 3 4\n");
    printf("Enter 0 0 0 to stop.\n");
```

* Resets `edge_count`.
* Displays instructions on how to enter edges.

---

```c
    while (1)
    {
        int u, v, w;
        printf("Edge (u v w): ");
        if (scanf("%d %d %d", &u, &v, &w) != 3)
        {
            printf("Invalid input! Try again.\n");
            while (getchar() != '\n');
            continue;
        }

        if (u == 0 && v == 0 && w == 0)
            break;
```

* Reads edges until the user enters `0 0 0` (stop signal).
* Checks for input format errors.

---

```c
        if (u < 1 || v < 1 || u > n || v > n)
        {
            printf("Invalid vertex number! Must be between 1 and %d.\n", n);
            continue;
        }

        if (w <= 0)
        {
            printf("Weight must be positive!\n");
            continue;
        }
```

* Validates vertex numbers and edge weights.

---

```c
        edges[edge_count].u = u - 1; // Convert to 0-based indexing
        edges[edge_count].v = v - 1;
        edges[edge_count].w = w;
        edge_count++;
    }

    printf("\nGraph loaded successfully! Total edges: %d\n", edge_count);
    mst_found = 0;
}
```

* Stores edge info in the `edges` array (0-based internally).
* Resets `mst_found` flag.

---

## ⚡ RUNNING KRUSKAL’S ALGORITHM

```c
void kruskal()
{
    if (n == 0)
    {
        printf("Graph not loaded yet!\n");
        return;
    }

    printf("\n----- Kruskal's Algorithm Running -----\n");
```

* Checks if graph is loaded before proceeding.

---

```c
    for (int i = 0; i < n; i++)
    {
        parent[i] = i;
        rank_arr[i] = 0;
    }
```

* Initializes **Disjoint Set Union**:

  * Each vertex is its own parent.
  * Rank = 0.

---

```c
    sort_edges();

    mst_edges = 0;
    min_cost = 0;
```

* Sort edges by weight.
* Reset MST data.

---

```c
    for (int i = 0; i < edge_count && mst_edges < n - 1; i++)
    {
        int u = edges[i].u;
        int v = edges[i].v;
        int w = edges[i].w;

        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV)
        {
            mst[mst_edges++] = edges[i];
            min_cost += w;
            union_sets(rootU, rootV);
        }
    }
```

* Traverse sorted edges.
* For each edge `(u, v, w)`:

  * Find their sets.
  * If they are **in different sets**, add the edge to the MST.
  * Merge the sets (`union_sets`).
* Continue until MST has `n - 1` edges.

---

```c
    if (mst_edges != n - 1)
    {
        printf("Graph is disconnected! MST could not be formed completely.\n");
        mst_found = mst_edges;
        return;
    }

    mst_found = 1;
    printf("Kruskal’s algorithm completed successfully!\n");
}
```

* If we didn’t get `n - 1` edges → graph is disconnected.
* Otherwise, MST successfully built.

---

## 📤 DISPLAYING MST

```c
void display_mst()
{
    if (n == 0 || !mst_found)
    {
        printf("ERROR: MST not yet calculated. Please select 1 and 2 first.\n");
        return;
    }
```

* Checks if MST exists before displaying.

---

```c
    printf("\n----- Minimum Spanning Tree (Kruskal’s) -----\n");
    printf("Total Vertices: %d\n", n);
    printf("Edges in MST:\n");
    for (int i = 0; i < mst_edges; i++)
    {
        printf("%d) (%d, %d) - Cost: %d\n", i + 1, mst[i].u + 1, mst[i].v + 1, mst[i].w);
    }
    printf("Total Minimum Cost: %d\n", min_cost);
}
```

* Prints all MST edges (converted back to 1-based numbering).
* Prints total cost of the MST.

---

## 🧭 MAIN MENU

```c
int main()
{
    printf("\n***** Kruskal's Algorithm *****\n");
    printf("%d is used for No edge (infinity)\n", no_edge);

    int ch;
    while (1)
    {
        printf("\n1) Read Graph (Edge List)\n");
        printf("2) Run Kruskal's Algorithm\n");
        printf("3) Display MST\n");
        printf("4) Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);
```

* Displays an interactive menu to the user.

---

```c
        switch (ch)
        {
        case 1:
            read();
            break;
        case 2:
            kruskal();
            break;
        case 3:
            display_mst();
            break;
        case 4:
            exit(0);
        default:
            printf("Invalid choice!\n");
        }
    }
    return 0;
}
```

* Calls the appropriate function based on user choice.
* Runs in a loop until the user chooses to exit.

---

## 🧾 Program Flow Summary

| Step | Function                  | Description                     |
| ---- | ------------------------- | ------------------------------- |
| 1️⃣  | `read()`                  | Read and store all graph edges  |
| 2️⃣  | `sort_edges()`            | Sort edges by weight            |
| 3️⃣  | `find()` / `union_sets()` | Used internally to avoid cycles |
| 4️⃣  | `kruskal()`               | Build the MST                   |
| 5️⃣  | `display_mst()`           | Show MST edges and cost         |

---

## ⚡ Example Run

```
***** Kruskal's Algorithm *****
-1 is used for No edge (infinity)

1) Read Graph (Edge List)
2) Run Kruskal's Algorithm
3) Display MST
4) Exit
Enter your choice: 1
Enter the number of vertices (max 50): 4
Enter edges in the format: <source> <destination> <weight>
1 2 1
1 3 3
2 3 2
2 4 4
3 4 5
0 0 0

Graph loaded successfully! Total edges: 5

Enter your choice: 2
----- Kruskal's Algorithm Running -----
Kruskal’s algorithm completed successfully!

Enter your choice: 3
----- Minimum Spanning Tree (Kruskal’s) -----
Edges in MST:
1) (1,2) - Cost: 1
2) (2,3) - Cost: 2
3) (2,4) - Cost: 4
Total Minimum Cost: 7
```

---

Would you like me to **add inline comments directly into your C code** (so you can compile and see comments in code itself)?
