# Function: y = (x + 3)^2
# def function(x):
#     return (x + 3)**2

# # Derivative: dy/dx = 2(x + 3)
# def derivative(x):
#     return 2*(x + 3)

# # Starting point
x = 2
# learning_rate = 0.1

# print("Starting x value:", x)

# # Perform Gradient Descent for 20 iterations
# for i in range(20):
#     grad = derivative(x)
#     x = x - learning_rate * grad
#     print("Iteration", i+1, ": x =", x, " y =", function(x))

# print("\nFinal value of x (approx minimum):", x)


import matplotlib.pyplot as plt


def func(x):
    return (x + 3) ** 2

def grad(x):
    return 2 * (x + 3)


# Lists to store steps for visualization
x_vals = [x]
y_vals = [func(x)]

# Starting point
x = 2
learning_rate = 0.1

# Gradient Descent Loop
for i in range(20):
    dx = grad(x)
    x = x - learning_rate * dx

    x_vals.append(x)
    y_vals.append(func(x))

    print(f"Iteration {i+1}: x = {x:.5f}, f(x) = {func(x):.5f}")


print(f"\nLocal minimum at x = {x:.5f}, f(x) = {func(x):.5f}")

# Plotting the function and steps
x_plot = [i for i in range(-10, 5)]
y_plot = [func(i) for i in x_plot]

plt.figure(figsize=(8,5))
plt.plot(x_plot, y_plot, label="y = (x + 3)^2")
plt.scatter(x_vals, y_vals, color='red', label="Gradient Descent Steps")
plt.plot(x_vals, y_vals, linestyle='--', color='gray', alpha=0.6)
plt.title("Gradient Descent to Find Local Minima")
plt.xlabel("x")
plt.ylabel("y")
plt.legend()
plt.grid(True)
plt.show()