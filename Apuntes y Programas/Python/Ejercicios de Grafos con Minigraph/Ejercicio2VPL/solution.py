import minigraph as nx
def build_graph(edges_list, num_nodes, num_edges):
    """
    Construye y devuelve un grafo no dirigido a partir de una lista de aristas.

    Parámetros:
        edges_list: lista de cadenas con las aristas del grafo.
            Cada cadena tiene el formato "u v", donde u y v son enteros.
            Ejemplo: ["1 4", "2 8", "3 6"]

        num_nodes: número total de vértices del grafo.
            Los vértices deben numerarse desde 1 hasta num_nodes.

        num_edges: número total de aristas del grafo.
            Coincide con el número de líneas contenidas en edges_list.

    Debe devolver:
        Un objeto nx.Graph() que contenga todos los vértices y todas las
        aristas indicadas en la entrada.

    Restricciones:
        - No leer de teclado ni de ficheros en esta función.
        - No imprimir nada en esta función.
        - No modificar main.py.
        - Usar nx.Graph(), add_node() y add_edge().
    """
    mi_grafo = nx.Graph()
    nodo_anterior = None
    for arista in edges_list:
        contador = 0
        for nodo in arista:
            if nodo != " ":
                if nodo not in mi_grafo.nodes():
                    mi_grafo.add_node(nodo)
                if contador > 0:
                    mi_grafo.add_edge(nodo_anterior, nodo)
                contador += 1
                nodo_anterior = nodo
    return mi_grafo


listanodos = ["1 2", "3 4", "5 6", "7 8", "7 5", "4 8"]

print(build_graph(listanodos, 5, 6).nodes())
