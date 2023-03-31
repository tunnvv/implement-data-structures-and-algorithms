from collections import defaultdict
from graphlib.utils import PriorityQueueWithFunction, Stack, Queue

class Graph(object):
    def __init__(self, components, direction=False):
        self._graph = defaultdict(list)
        self._direction = direction
        self.add_components(components)

    def add_edge(self, src, des, action, distance):
        self._graph[src].append((des, action, distance))
        if not self._direction:
            self._graph[des].append((src, action, distance))
            return
        self._graph[des] = []

    def add_components(self, components):
        for src, des, action, distance in components:
            self.add_edge(src, des, action, distance)

    def is_connected(self, vA, vB):
        return vA in self._graph and vB in self._graph[vA]

    def remove(self, vA):
        """ Remove all references to node """
        for k in self._graph:
            for vertex, action, distance in self._graph[k]:
                if vertex == vA:
                    try:
                        self._graph[k].remove((vertex, action, distance))
                    except KeyError:
                        pass
        try:
            del self._graph[vA]
        except KeyError:
            pass

    def getFringe(self, vertex):
        return self._graph[vertex]

def nullHeuristic():
    return 0

def depthFirstSearch(graph: Graph, start, des):
    # count = 1
    stack = Stack()
    visited = dict()
    visited[start] = (None, None, 0)
    stack.push((None, start, None, 0))

    def pathTo(end):
        state, _, cost = visited[end]
        total_cost = cost
        paths = [des]
        while state is not None:
            paths.append(state)
            state, _, cost = visited[state]
        return [paths[::-1], total_cost]

    while not stack.isEmpty():
        prev, cur, recent_action, cost = stack.pop()
        # print(cur)
        if cur == des:
            # print(count)
            return pathTo(des)

        for next, action, added_cost in graph.getFringe(cur):
            if next not in visited:
                # count += 1
                visited[next] = (cur, action, cost + added_cost)
                stack.push((cur, next, action, cost + added_cost))

    return []

def breadthFirstSearch(graph: Graph, start, des):
    # count = 0
    queue = Queue()
    visited = dict()
    visited[start] = (None, None, 0)
    queue.push((None, start, None, 0))

    def pathTo(end):
        state, _, cost = visited[end]
        total_cost = cost
        paths = [des]
        while state is not None:
            paths.append(state)
            state, _, cost = visited[state]
        return [paths[::-1], total_cost]

    while not queue.isEmpty():
        prev, cur, recent_action, cost = queue.pop()
        print(prev)
        if cur == des:
            # print(count)
            return pathTo(des)

        for next, action, added_cost in graph.getFringe(cur):
            if next not in visited:
                # count += 1
                visited[next] = (cur, action, cost + added_cost)
                queue.push((cur, next, action, cost + added_cost))
    return []

def uniformCostSearch(graph: Graph, start, des):
    def Fn(item):
        vA, vB, action, cost = item
        return cost

    heapq = PriorityQueueWithFunction(Fn)
    visited = dict()
    heapq.push((None, start, None, 0))
    visited[start] = (None, None, 0)

    def pathTo(end):
        state, _, cost = visited[end]
        total_cost = cost
        paths = [des]
        while state is not None:
            paths.append(state)
            state, _, cost = visited[state]
        return [paths[::-1], total_cost]

    while not heapq.isEmpty():
        prev, cur, recent_action, cost = heapq.pop()
        if cur == des:
            return pathTo(cur)

        for next, action, added_cost in graph.getFringe(cur):
            new_cost = cost + added_cost
            if next not in visited:  #
                heapq.push((cur, next, action, new_cost))
                visited[next] = (cur, action, new_cost)
            else:
                _, _, old_cost = visited[next]
                if new_cost < old_cost:
                    heapq.push((cur, next, action, new_cost))
                    visited[next] = (cur, action, new_cost)

    return []

def bestFirstSearch(graph: Graph, start, des, heuristic=nullHeuristic):
    # count = 1
    def Fn(item):
        vA, vB, action, cost = item
        return heuristic[vB]

    heapq = PriorityQueueWithFunction(Fn)
    visited = dict()
    heapq.push((None, start, None, 0))
    visited[start] = (None, None, 0)

    def pathTo(end):
        state, _, cost = visited[end]
        total_cost = cost
        paths = [des]
        while state is not None:
            paths.append(state)
            state, _, cost = visited[state]
        return [paths[::-1], total_cost]

    while not heapq.isEmpty():
        prev, cur, recent_action, cost = heapq.pop()
        # print(cur)
        if cur == des:
            # print(count)
            return pathTo(des)

        for next, action, added_cost in graph.getFringe(cur):
            if next not in visited:
                # count += 1
                heapq.push((cur, next, action, cost + added_cost))
                visited[next] = (cur, action, cost + added_cost)

    return []

def aStarSearch(graph: Graph, start, des, heuristic=nullHeuristic):
    def Fn(item):
        vA, vB, action, cost = item
        return cost + heuristic[vB]

    heapq = PriorityQueueWithFunction(Fn)
    visited = dict()
    heapq.push((None, start, None, 0))
    visited[start] = (None, None, 0)

    def pathTo(end):
        state, _, cost = visited[end]
        total_cost = cost
        paths = [des]
        while state is not None:
            paths.append(state)
            state, _, cost = visited[state]
        return [paths[::-1], total_cost]

    while not heapq.isEmpty():
        prev, cur, recent_action, cost = heapq.pop()
        if cur == des:
            return pathTo(cur)

        for next, action, added_cost in graph.getFringe(cur):
            new_cost = cost + added_cost
            if next not in visited:             # go to next for the first time
                heapq.push((cur, next, action, new_cost))
                visited[next] = (cur, action, new_cost)
            else:
                _, _, old_cost = visited[next]
                if new_cost < old_cost:         # find new cost to go to next is lower
                    heapq.push((cur, next, action, new_cost))
                    visited[next] = (cur, action, new_cost)

    return []















