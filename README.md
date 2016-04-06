# codepractice
1) Topological sorting, e.g. course schedule problem.
The course prerequisites between courses form edges between course node. Finding a possible schedule of courses could be solved by topological sorting technique. Potentially, there are might be more than one graph in the adject list. Considering exploring the graph start from course num 0 tend to run into a bug since it covered a partial of the whole graph. Therefore, we need

<code>
for(int i=0; i\<numOfCourses; i++){
    if(isVisited(course[i])) continue;
    explore(course[i], adjcentList, path);
}
</code>

2) very common to see a combination of recursion/dfs with backtracking algorithm.
Backtracking is usedfor finding all (or some) solutions to some computational problems. It usually builds candidates to the solution
incrementally in a principle way such as DFS and abandons each partial candidate c ("backtrack") as soon as it determines that c cannot 
be a valid result in the solutions. For example, the reconstruct itinerary problem.
<a href="https://github.com/tmw507/codepractice/blob/master/Permute.java"> Permute </a>

