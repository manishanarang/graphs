​You actually add all the gates to the queue first.
Then you start doing BFS one by one. And when you do BFS, you only update just the next(+1 on all sides) next to the current gate. Then you add the neighbouring element to the end of the queue (which will be all the way after all
the gates you added in the beginning). So when a node is actually visited first, it will be visited from the nearest gate. Once visited by a gate, you dont even bother checking distance with another gate, so its more optimized.
