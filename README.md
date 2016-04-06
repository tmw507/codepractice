# codepractice
DFS on a graph:
1) need to consider the problem of multiple seperate graph contained in the adjecent list. For example, the course schedule problem can
have multiple seperate graphs. Considering only start at the course num 0 tend to run into a bug since it covered a partial of the whole
graph.

for(int i=0; i<numOfCourses; i++){
    if(isVisited(course[i])) continue;
    dfs(course[i], adjcentList, path);
}
2) very common to see a combination with backtracking algorithm.
Backtracking is usedfor finding all (or some) solutions to some computational problems. It usually builds candidates to the solution
incrementally in a principle way such as DFS and abandons each partial candidate c ("backtrack") as soon as it determines that c cannot 
be a valid result in the solutions. For example, the reconstruct itinerary problem.
