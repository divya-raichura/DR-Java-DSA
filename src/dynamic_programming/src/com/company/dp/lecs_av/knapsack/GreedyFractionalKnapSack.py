def knapsack(capacity, items):
  items.sort(key=lambda x: x[1]/x[0], reverse=True)
  total_value = 0
  for item in items:
    if capacity - item[0] >= 0:
      capacity -= item[0]
      total_value += item[1]
    else:
      fraction = capacity/item[0]
      total_value += item[1]*fraction
      break
  return total_value

if __name__ == '__main__':
  items = [(10, 60), (20, 100), (30, 120)]
  capacity = 50
  print(knapsack(capacity, items))
