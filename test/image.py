import matplotlib.pyplot as plt

# Given data
n_values = [10, 50, 100, 500, 1000, 2000, 3000]
y1_values = [0, 1, 2, 42, 164, 647, 1399]
y2_values = [2, 5, 9, 44, 106, 176, 301]

# Plotting the graph
plt.plot(n_values, y1_values, color='red', label='y1')
plt.plot(n_values, y2_values, color='blue', label='y2')
plt.legend()
plt.xlabel('n')
plt.ylabel('y')
plt.title('Graph of y1 and y2 as a Function of n')

# Saving the image as a file
plt.savefig('y1_y2_graph.png')
