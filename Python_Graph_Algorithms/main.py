from graphlib import *

components = [('Arad', 'Zerind', None, 75), ('Arad', 'Sibiu', None, 140), ('Arad', 'Timisoara', None, 118),
              ('Zerind', 'Oradea', None, 71), ('Oradea', 'Sibiu', None, 151), ('Timisoara', 'Lugoj', None, 111),
              ('Lugoj', 'Mehadia', None, 70),('Mehadia', 'Drobeta', None, 75), ('Drobeta', 'Craiova', None, 120),
              ('Sibiu', 'Fagaras', None, 99), ('Sibiu', 'Rimnicu Vilcea', None, 80),
              ('Rimnicu Vilcea', 'Pitesti', None, 97), ('Rimnicu Vilcea', 'Craiova', None, 146),
              ('Craiova', 'Pitesti', None, 138), ('Fagaras', 'Bucharest', None, 211),
              ('Pitesti', 'Bucharest', None, 101), ('Bucharest', 'Giurgiu', None, 90),
              ('Bucharest', 'Urziceni', None, 85), ('Urziceni', 'Vaslui', None, 142),
              ('Vaslui', 'Iasi', None, 92), ('Iasi', 'Neamt', None, 87),
              ('Urziceni', 'Hirsova', None, 98), ('Hirsova', 'Eforie', None, 86)]

heuristicBucharest = {'Arad': 366, 'Bucharest': 0, 'Craiova': 160, 'Drobeta': 242, 'Eforie': 161, 'Fagaras': 178,
        'Giurgiu': 77, 'Hirsova': 151, 'Iasi': 226, 'Lugoj': 244, 'Mehadia': 241, 'Neamt': 234,
        'Oradea': 380, 'Pitesti': 98, 'Rimnicu Vilcea': 193, 'Sibiu': 253, 'Timisoara': 329,
        'Urziceni': 80, 'Vaslui': 199, 'Zerind': 374}

characters = [('s', 'a', None, 6), ('s', 'b', None, 5), ('s', 'c', None, 10), ('a', 'e', None, 6),
             ('b', 'e', None, 6), ('b', 'd', None, 7), ('c', 'd', None, 6), ('e', 'f', None, 4),
             ('d', 'f', None, 6), ('f', 'g', None, 3), ('l', 's', None, 5), ('m', 's', None, 3)]
inf = {'s': 17, 'a': 10, 'c': 14, 'b': 13, 'e': 4, 'd': 2, 'f': 1, 'g': 0, 'l': 21, 'm': 22}


city = Graph(characters)
print(aStarSearch(city, 's', 'g', inf))
print(uniformCostSearch(city, 's', 'g'))

"""
city = Graph(components)
print(aStarSearch(city, 'Arad', 'Bucharest', heuristicBucharest))
print(uniformCostSearch(city, 'Arad', 'Bucharest'))
"""